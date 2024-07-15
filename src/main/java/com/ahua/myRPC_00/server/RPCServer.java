package com.ahua.myRPC_00.server;


import com.ahua.myRPC_00.common.User;

import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 86188
 */
public class RPCServer  {
    public static void main(String[] args){
        UserServiceImpl userService=new UserServiceImpl();
        try {
            ServerSocket serverSocket=new ServerSocket(8899);
            System.out.println("服务端开启");
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("连接成功");
                new Thread(()->{
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
                }).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
