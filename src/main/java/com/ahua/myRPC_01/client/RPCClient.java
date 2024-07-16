package com.ahua.myRPC_01.client;

import com.ahua.myRPC_01.common.User;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

/**
 * @author 86188
 */
public class RPCClient {
    public static void main(String[] args){
        try{
            while(true){
                Socket socket=null;
                try{
                    socket=new Socket("localhost",8899);

                    //读取并输出用户ID
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    Integer userId = Integer.parseInt(reader.readLine());

                    ObjectOutputStream output=new ObjectOutputStream(socket.getOutputStream());
                    output.writeObject(userId);

                    //获取返回结果
                    ObjectInputStream input=new ObjectInputStream(socket.getInputStream());
                    User user=(User) input.readObject();

                    System.out.println("响应！");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if(socket!=null){
                        try {
                            socket.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
