import java.util.Scanner;

public abstract class ContaBancaria {
	
private int numero;
private double saldo;
private String senha=null;

protected int getNumero() {
	return numero;
}
protected void setNumero(int numero) {
	this.numero = numero;
}
protected double getSaldo() {
	return saldo;
}






protected  double saca(Scanner in) {
	if(saldo==0) {
		System.out.println("Saldo Insuficiente!");
		}else{
	
	double valordesaque = in.nextDouble();
		if(valordesaque<=saldo) {
			saldo=saldo-valordesaque;
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




protected  void tiraExtrato() {
	
}






protected String alteraSenha(Scanner in) {
	String novaSenha;
	String verificaSenha;
	if(senha==null) {
		System.out.println("Digite Sua Nova Senha: ");
		novaSenha= in.next();
		senha=novaSenha;
	}else
		if(senha!=null) {
		System.out.println("Digite Sua Senha Anterior: ");
		verificaSenha=in.next();
		if(verificaSenha==senha) {
			System.out.println("Digite Sua Nova Senha: ");
			novaSenha= in.next();
			senha=novaSenha;
		}else
			System.out.println("SenhaInvalida!");
		}
	 return senha;
	
 }
}
