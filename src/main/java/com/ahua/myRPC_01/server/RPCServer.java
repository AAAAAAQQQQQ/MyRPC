package com.ahua.myRPC_01.server;


import com.ahua.myRPC_01.common.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 86188
 */
public class RPCServer  {
    public static void main(String[] args){
        UserServiceImpl userService=new UserServiceImpl();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            ServerSocket serverSocket=new ServerSocket(8899);
            System.out.println("服务端开启");

            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("连接成功");
                executorService.execute(()->{
                    try {
                        ObjectInputStream input=new ObjectInputStream(socket.getInputStream());
                        Integer id=(Integer) input.readObject();

                        //创建对象
                        User user=userService.getUserByUserId(id);

                        //返回客户端
                        ObjectOutputStream output=new ObjectOutputStream(socket.getOutputStream());
                        output.writeObject(user);

                        socket.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
