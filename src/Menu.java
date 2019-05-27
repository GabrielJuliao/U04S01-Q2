import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	private int x;
	private static int check=1;
	private ArrayList<ContaCorrente> listcorrente = new ArrayList<>();
	private ArrayList<ContaPoupanca> listpoupanca = new ArrayList<>();
	Scanner in = new Scanner(System.in);
	
	
	public void menuPrincipal() {
		int s=0;
		int x=0;
		boolean w = true;
		while(w) {
			
			System.out.println("1-AcessarConta, 2-CriaNovaConta");
			
			try {
				x = in.nextInt();
			if(x==1) {
				menuSecundario();
			}else
				if(x==2) {
					menuNovaConta();
				}
			}catch(InputMismatchException e) {
				System.out.println("EntradaInvalida!");
			}
		}
	}
	
	
	
public void menuSecundario() {
	System.out.println("1-ContaCorrente, 2-ContaPoupança");
	int filtro;
	filtro=in.nextInt();
	if(filtro==1) {
		menuContaCorrente();
	}else
		if(filtro==2) {
			menuContaPoupanca();
		}else
			System.out.println("EntradaInvalida!");
}





public void menuContaCorrente() {
	System.out.println("Digite O Numero Da Sua Conta:");
	check = in.nextInt();
	int s =0;
	for(ContaCorrente contacorrente : listcorrente)
	    if(contacorrente.getNumero()==check) {
	    	System.out.println("ContaNumero: "+contacorrente.getNumero());
	    	
	    	if(contacorrente.verificaSenha(in)) {
	    		
	    System.out.println("1-Saca, 2-Deposita");
	    System.out.println("3-Extrato, 4-Num de Transaçoes");
	    System.out.println("5-AlterarSenha, Outros-Sair");
	    s = in.nextInt();
	    switch(s) {
	    case 1:
	    	contacorrente.saca(in);
	    	break;
	    case 2:
	    	contacorrente.deposita(in);
	    	break;
	    case 3:
	    	contacorrente.tiraExtrato();
	    	break;	    	
	    case 4:
	    	contacorrente.getNum();
	    	break;
	    case 5:
	    	contacorrente.alteraSenha(in);
	    default:
	    	break;
	    }
	 }	
   }	    	
}



public void menuContaPoupanca() {
	System.out.println("Digite O Numero Da Sua Conta:");
	check = in.nextInt();
	int s =0;
	for(ContaPoupanca contapoupanca : listpoupanca)
	    if(contapoupanca.getNumero()==check) {
	    	System.out.println("ContaNumero: "+contapoupanca.getNumero());
	    	
	    if(contapoupanca.verificaSenha(in)) {	
	    	System.out.println("1-Saca, 2-Deposita");
	 	    System.out.println("3-Extrato, 4-Num de Transaçoes");
	 	    System.out.println("5-AlterarSenha, Outros-Sair");
	 	    s = in.nextInt();
	    switch(s) {
	    case 1:
	    	contapoupanca.saca(in);
	    	break;
	    case 2:
	    	contapoupanca.deposita(in);
	    	break;
	    case 3:
	    	contapoupanca.tiraExtrato();
	    	break;	    	
	    case 4:
	    	contapoupanca.taxaRendimento();
	    	break;
	    case 5:
	    	contapoupanca.alteraSenha(in);
	    default:
	    	break;
	    }
	}
  }
}
	
	
	
public void menuNovaConta() {
	x=0;
	
	System.out.println("1-NovaContaCorrente, 2-NovaContaPoupança");
	try {
		
		x = in.nextInt();
	if(x==1) {
		verifica();
		System.out.println("Anote O Numero Da Sua Conta: "+check);
		ContaCorrente contacorrente = new ContaCorrente();
		contacorrente.setNumero(check);
		contacorrente.alteraSenha(in);
		listcorrente.add(contacorrente);
	}else
		if(x==2) {
		verifica();
		System.out.println("Anote O Numero Da Sua Conta: "+check);
		ContaPoupanca contapoupanca = new ContaPoupanca();
		contapoupanca.setNumero(check);
		contapoupanca.alteraSenha(in);
		listpoupanca.add(contapoupanca);
		}
		
	}catch(InputMismatchException e) {
		System.out.println("EntradaInvalida!");
	}
}



public int verifica() {
	if(x==1) {
	for(ContaBancaria contacorrente : listcorrente)
	    if(contacorrente.getNumero()==check) {
	    	check = contacorrente.getNumero()+1;

}
	}else
		if(x==2) {
			for(ContaBancaria contapoupanca : listpoupanca)
			    if(contapoupanca.getNumero()==check) {
			    	check = contapoupanca.getNumero()+1;
		}
	}
	return check;
}
}
