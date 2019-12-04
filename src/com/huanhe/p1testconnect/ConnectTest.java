package com.huanhe.p1testconnect;

import com.ib.client.EClientSocket;
import com.ib.client.EReader;
import com.ib.client.EReaderSignal;
import com.ib.controller.ApiController;

import javax.swing.*;
import java.io.IOException;

public class ConnectTest {
    public static void main(String[] args) {

        /*
         * new EWrapperImpl 生成了3个对象
         * 创建 EJavaSignal 和 EClientSocket 对象的对象
         * EJavaSignal 对象
         * EClientSocket 对象
         */
        EWrapperImpl wrapper = new EWrapperImpl();


        //取得 EJavaSignal对象
        EReaderSignal m_signal = wrapper.getSignal();
        //取得 EClientSocket对象
        EClientSocket m_socket = wrapper.getSocket();

        //建立连接
        m_socket.eConnect("127.0.0.1", 4001, 0);

        final EReader reader = new EReader(m_socket, m_signal);
        reader.start();

        new Thread(() -> {
            while (m_socket.isConnected()){
                m_signal.waitForSignal();
            }

            try {
                reader.processMsgs();
            } catch (IOException e) {
//                    e.printStackTrace();
                System.out.println("Exception: " + e.getMessage());
            }
        });

    }
}
