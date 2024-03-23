package exemplo1;

public class TestaMoto {

	public static void main(String[] args) {
		Moto moto = new Moto("CG Titan");
		
		moto.acelera(60);
		System.out.println(moto.getVelocidade()==60); //60
		moto.acelera(60);
		moto.acelera(60);
	
		System.out.println(moto.getVelocidade()==150);//150
		
		moto.freia(80);
		System.out.println(moto.getVelocidade()==70); //70
		
		moto.freia(80);
		System.out.println(moto.getVelocidade()==0); //0
		
		try {
			moto.acelera(-5);
			System.out.println(false);
		}catch(RuntimeException e) {
			System.out.println(true);
		}
	}

}
