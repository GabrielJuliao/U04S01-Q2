
public class ContaCorrente extends ContaBancaria{
private int qtdtr = 0;	
protected int getQtdtr() {
	qtdtr++;
	return qtdtr;
}

}
