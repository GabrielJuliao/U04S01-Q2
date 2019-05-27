import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public abstract class ContaBancaria {
	
private int numero=10;
private double saldo;
private String senha=null;

protected int getNumero() {
	return numero;
}
protected void setNumero(int numero) {
	this.numero = numero;
}



protected  double saca(Scanner in) {
	if(saldo==0) {
		System.out.println("Saldo Insuficiente!");
		}else{
	System.out.println("Valor De Saque: ");
	double valordesaque = in.nextDouble();
		if(valordesaque<=saldo) {
			saldo=saldo-valordesaque;
			System.out.println("Saldo Atual: "+saldo);
		}else
			System.out.println("Valor Indisponivel!");
		}
	return saldo;
}





protected  double deposita(Scanner in) {
	System.out.println("Valor Do Deposito");
	double valordedep;
	valordedep = in.nextDouble();
	saldo=saldo+valordedep;
	return saldo;
}




protected  double tiraExtrato() {
	return saldo;	
}






protected String alteraSenha(Scanner in) {
	String novaSenha;
	String verificaSenha;
	if(senha==null) {
		System.out.println("Digite Sua Nova Senha: ");
		novaSenha= in.next();
		senha = encrypt(novaSenha);
	}else
		if(senha!=null) {
		System.out.println("Digite Sua Senha Anterior: ");
		verificaSenha=in.next();
		if(verificaSenha==senha) {
			System.out.println("Digite Sua Nova Senha: ");
			novaSenha= in.next();
			senha = encrypt(novaSenha);
		}else
			System.out.println("SenhaInvalida!");
		}
	 return senha;
	
 }
public boolean verificaSenha(Scanner in) {
	String senhaentrada;
	boolean auth=false;
	
	System.out.println("Digite A Senha Cadastrada!");
	senhaentrada = encrypt(in.next());
	
	if(senhaentrada.equals(senha)) {
		auth=true;
		}else
			System.out.println("SenhaInvalida!");
	
	
	return auth;
}


/////////cipher//////////////////////////////////////////////////////////////
private static final String key = "aesEncryptionKey";
private static final String initVector = "encryptionIntVec";

public static String encrypt(String value) {
	try {
		IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
		SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

		byte[] encrypted = cipher.doFinal(value.getBytes());
		return Base64.encode(encrypted);
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	return null;
}
}
