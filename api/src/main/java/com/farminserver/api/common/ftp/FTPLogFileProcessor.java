package com.farminserver.api.common.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;

@Service
public class FTPLogFileProcessor {

    private static final String FTP_SERVER = "farm-in.ipdisk.co.kr";
    private static final String FTP_USER = "farmin";  // FTP 서버 계정 정보
    private static final String FTP_PASSWORD = "farmin230130";
    private static final String FTP_LOG_DIRECTORY = "/HDD1/monitoring";  // .log 파일이 저장된 FTP 경로
    private static final String LOCAL_SAVE_DIRECTORY = "/home/farmin/바탕화면/log";  // 로컬에 저장할 경로

    private static final String DB_URL = "jdbc:mysql://192.168.0.20:3306/FarmInServer";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "230130";

    @PostConstruct // 애플리케이션 시작 시 실행
    public void init() {
        processFTPLogs();
    }

    public void processFTPLogs() {
        FTPClient ftpClient = new FTPClient();
        int retryCount = 0;
        boolean connected = false;

        // FTP 연결 재시도
        while (!connected && retryCount < 5) {
            try {
                ftpClient.connect(FTP_SERVER);
                ftpClient.login(FTP_USER, FTP_PASSWORD);
                ftpClient.enterLocalPassiveMode(); // 패시브 모드 설정
                System.out.println("FTP 서버에 성공적으로 연결되었습니다.");
                connected = true;
            } catch (IOException e) {
                retryCount++;
                System.out.println("FTP 서버 연결 실패. 재시도 중..." + retryCount);
                e.printStackTrace(); // 연결 실패 원인 출력
                try {
                    Thread.sleep(3000); // 3초 대기 후 재시도
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }

        if (connected) {
            try {
                // FTP 서버에서 파일 목록 가져오기
                ftpClient.changeWorkingDirectory(FTP_LOG_DIRECTORY);
                String[] logFiles = ftpClient.listNames("*.log");

                if (logFiles != null && logFiles.length > 0) {
                    System.out.println("FTP 서버에서 파일 목록을 성공적으로 가져왔습니다.");
                    for (String logFile : logFiles) {
                        System.out.println("파일 찾음: " + logFile);
                        // 로컬에 파일 저장
                        File localFile = new File(LOCAL_SAVE_DIRECTORY + "/" + logFile);
                        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(localFile))) {
                            boolean success = ftpClient.retrieveFile(logFile, outputStream);
                            if (success) {
                                System.out.println(logFile + " 파일이 로컬에 저장되었습니다.");
                                // 파일 내용을 읽어 DB에 저장
                                processLogFileAndSaveToDB(localFile);
                            } else {
                                System.out.println(logFile + " 파일 다운로드 실패.");
                            }
                        }
                    }
                } else {
                    System.out.println("FTP 서버에서 .log 파일을 찾을 수 없습니다.");
                }
            } catch (IOException e) {
                System.out.println("FTP 서버에서 파일 목록을 가져오는 중 오류 발생.");
                e.printStackTrace();
            } finally {
                try {
                    ftpClient.logout();
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("FTP 서버에 연결할 수 없습니다.");
        }
    }

    // 로그 파일을 처리하여 DB에 저장하는 메서드
    private void processLogFileAndSaveToDB(File logFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 로그 파일의 내용을 DB에 저장 (예시)
                saveLogToDatabase(line, logFile.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 로그 내용을 DB에 저장하는 메서드
    private void saveLogToDatabase(String logLine, String logFileName) {
        String insertSQL = "INSERT INTO log_data (log_file_name, log_line, log_timestamp) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = conn.prepareStatement(insertSQL)) {

            preparedStatement.setString(1, logFileName);
            preparedStatement.setString(2, logLine);
            preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("로그 데이터가 DB에 저장되었습니다: " + logLine);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
