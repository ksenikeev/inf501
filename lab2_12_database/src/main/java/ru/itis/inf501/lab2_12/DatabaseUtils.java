package ru.itis.inf501.lab2_12;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class DatabaseUtils {
    private static final String FILE_NAME = "db.tbl";
    private static long fileSize;
    private static Map<Integer,Long> indexes;

    public DatabaseUtils() throws IOException {
        init();
    }

    public void save(Wastes wastes) throws IOException{
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             FileOutputStream fos = new FileOutputStream(FILE_NAME,true);
             ObjectOutputStream os = new ObjectOutputStream(bos);
             DataOutputStream dos = new DataOutputStream(fos)) {
            os.writeObject(wastes);
            byte[] buff = bos.toByteArray();
            dos.writeInt(wastes.getId());
            dos.writeByte(1);
            dos.writeInt(buff.length);
            dos.write(buff);
            fos.flush();

            indexes.put(wastes.getId(), fileSize);
            fileSize += 4 + 1 + 4 + buff.length;

        }
    }

    public void init() throws IOException{
        indexes = new HashMap<>();
        fileSize = 0;
        Long position = 0L;
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
        DataInputStream dis = new DataInputStream(fis)) {
            while (dis.available() > 0) {
                int id = dis.readInt();
                byte flag = dis.readByte();
                int size = dis.readInt();
                dis.skip(size);
                if (flag == 1) {
                    indexes.put(id, position);
                }
                position += 9 + size;
                fileSize = position;
            }
        } catch(FileNotFoundException e) {
            System.out.println("Зафиксирован первый старт");
        }
    }

    public Wastes findById(Integer id) throws IOException, ClassNotFoundException{
        Long position = indexes.get(id);
        Wastes result;
        if (position == null) {
            throw new NoSuchElementException();
        }
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
        DataInputStream dis = new DataInputStream(fis);
        ) {
            dis.skip(position);
            dis.readInt();
            dis.read();
            int size = dis.readInt();
            byte[] buff = new byte[size];
            dis.read(buff);
            // Здесь нужно делать цикл!
            ByteArrayInputStream bis = new ByteArrayInputStream(buff);
            ObjectInputStream ois = new ObjectInputStream(bis);
            result = (Wastes) ois.readObject();
        }
        return result;
    }
}
