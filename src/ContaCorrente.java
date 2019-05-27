
public class ContaCorrente extends ContaBancaria{
private int num = 0;
public int getNum() {
	return num;
}
protected int numTransacoes() {
	num++;
	return num;
}

}
