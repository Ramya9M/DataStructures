package Arrays;

public class GoldenRetriever extends Dog {
    public void makenoise() {
        super.makenoise();
        System.out.println(" Make Golden Retriever Noise");
    }

    public static void main(String args[]) {

//        try{
//            ServerSocket serverSocket =new ServerSocket(9999);
//            Socket socket = serverSocket.accept();
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            String message = in.readLine();
//            System.out.println("Client: "+ message);
//            socket.close();
//            serverSocket.close();
//        } catch (IOException e) {
//            e.printStackTrace();

        int a = 4;
        int b = 0;
        int c = -1;

        try {
            c = a / b;
        } catch (Exception e) {
            System.out.println("Exception ");

        } finally {
            System.out.println("Finally ");
        }
        System.out.println(c);
    }
}

