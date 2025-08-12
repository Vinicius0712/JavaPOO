import java.net.InetAddress;

public class Ping {
	
	public static void main(String[] args) {
		
		try {
			
			long start = System.currentTimeMillis();
			
			if (InetAddress.getByName("172.16.2.98").isReachable(5000))
				System.out.println("OK!");
			
			else System.out.println ("Erro");
			
			long elapsedTimeMillis = System.currentTimeMillis()-start;
			float elapsedTimeSec = elapsedTimeMillis/1000F;
			System.out.println("Sec: " + elapsedTimeSec);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro no try");
		}
	}
}