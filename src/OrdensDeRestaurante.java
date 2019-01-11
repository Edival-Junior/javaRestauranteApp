/*
 * @Autor: Edival Aparecido da Silva Junior
 * @Date: 11/01/2019
 * 
 * */

import java.util.Scanner;

public class OrdensDeRestaurante {

	public static void main(String[] args) {
		//desenvolver uma solução para restaurantes
		//primeiramente o usuario deve escolher o periodo da refeição (manhã ou noite)
		//para a manhã, deve ser listado as opções de prato principal(ovos), acompanhamento(torradas) e bebida(café) 
		//para a noite, deve ser listado as opções de prato principal(bife), acompanhamento(batatas), bebida(vinho) e sobremesa(bolo) 
		//nas manhãs, o cliente pode pedir ilimitadas xicaras de café
		//durante a noite, o cliente pode pedir ilimitadas porções de batata
		
		Scanner scan = new Scanner(System.in); // inicializa o Scanner, responsavel por receber a entrada de dados do usuario
		System.out.println("Olá, \nPara ver fazer seu pedido digite \"manha\" para os pratos matinais e \"noite\" para os pratos noturnos.");
		String horario = scan.next();	 // atribui a informação inserida pelo usuario e  atribui a informação na variavel "horario"
		if(!horario.equalsIgnoreCase("Noite")) { //verifica se o usuario inseriu um valor diferente de "noite"
		char[] hora = horario.toCharArray(); // transforma a informação em um array 
		hora[4] = 'ã'; // substitui o valor da posição 4 do array para "ã"
		horario = new String(hora); //retorna a nova informação para a variavel "horario"
		}
		horario = horario.substring(0, 1).toUpperCase() + horario.substring(1).toLowerCase(); // Faz a formatação do texto, deixando a primeira letra em caixa alta e as seguintes em caixa baixa

		
		switch(horario){ //le o valor de horario
		case "Manhã": //se o valor de horario for correspondente a "Manhã", inicia esse bloco de codigo
			System.out.println("Pratos matinais"); //Lista as opções ao usuario
			System.out.println("1 - Principal: Ovo"); 
			System.out.println("2 - Acompanhamento: Torradas");
			System.out.println("3 - Bebida: Café");
			System.out.println("Para solicitar seu pedido, Digite o numero refetente a opção desejada!\n"
					+ "A quantidade de xicaras de café pode ser maior que 1\n"
					+ "Exemplo de pedido: 1233 (Ovo, torradas e duas xicaras de café)");
			String pedidoManha = scan.next(); //recebe o pedido do usuario
		
			char[] pedidosManha = pedidoManha.toCharArray(); // transforma o pedido do usuario em um array 
			
			int ovos=0, torradas = 0, cafe = 0, invalidasManha=0;  // inicializam-se variaveis para receber cada quantia
			for(int i = 0; i < pedidosManha.length ; i++) { //todas as posições do array são lidas 
				switch (pedidosManha[i]) { // cada item do array é direcionado para um incremento de variavel 
					case '1':
						ovos++;
					break;
					
					case '2':
						torradas++;
					break;
					
					case '3':
						cafe++;
					break;
					
					default: invalidasManha++; break; // caso o item não corresponda, é incrementado a variavel de entradas invalidas 
				}
			}
			
			if(ovos > 1) { // caso o usuario tente solicitar mais do que o permitido, o usuario será informado do limite e seu pedido será alterado
				System.out.println("Os ovos estão limitados a uma unidade por pedido!\nSeu pedido foi alterado para: 1 Ovo");
				ovos = 1;
			}
			if(torradas > 1) {
				System.out.println("As torradas estão limitados a uma unidade por pedido!\nSeu pedido foi alterado para: 1 Torrada");
				torradas = 1;
			}
			if (invalidasManha>0){
				System.out.println("Pedido final: \nOvo: "+ovos+"\nTorradas: "+torradas+"\nXicaras de Café: "+cafe+"\n"+invalidasManha+" Opções inválidas.\nAguarde enquanto preparamos seu pedido e bom apetite!");
			}
			else {
			System.out.println("Pedido final: \nOvo: "+ovos+"\nTorradas: "+torradas+"\nXicaras de Café: "+cafe+"\nAguarde enquanto preparamos seu pedido e bom apetite!");
			}
			break;
			
		case "Noite": // caso o usuario informe o valor "Noite", esse trecho de código é executado 
			System.out.println("Pratos noturnos"); // são listadas as opções noturnas
			System.out.println("1 - Principal: Bife");
			System.out.println("2 - Acompanhamento: Batatas");
			System.out.println("3 - Bebida: Vinho");
			System.out.println("3 - Sobremesa: Bolo");
			System.out.println("Para solicitar seu pedido, Digite o numero refetente a opção desejada!\n"
					+ "A quantidade de porções de batata pode ser maior que 1\n"
					+ "Exemplo de pedido: 12234 (Bife, duas porções de batata, uma taça de vinho e um pedaço de bolo)");
			String pedidoNoite = scan.next(); //O usuario faz seu pedido
		
			char[] pedidosNoite = pedidoNoite.toCharArray(); // O pedido é transformado em um array 
			
			int bife=0, batatas = 0, vinho = 0, bolo = 0, invalidasNoite= 0;  // as variaveis de contagem são inicializadas
			for(int i = 0; i < pedidosNoite.length ; i++) { // Todos os itens do pedido são lidos e encaminhados para suas variaveis 
				switch (pedidosNoite[i]) {
					case '1':
						bife++;
					break;
					
					case '2':
						batatas++;
					break;
					
					case '3':
						vinho++;
					break;
					
					case '4':
						bolo++;
					break;
					
					default: invalidasNoite++; break; // caso o  valor não  esteja entre os valores esperados, é adicionado a entrada invalida 
				}
			}
			
			if(bife > 1) { // caso o usuario solicite uma quantidade acima do limite, o usuario é informado e seu pedido é alterado 
				System.out.println("A quantidade de bife está limitada a uma unidade por pedido!\nSeu pedido foi alterado para: 1 Bife");
				bife = 1;
			}
			if(vinho > 1) {
				System.out.println("As taças de vinho estão limitadas a uma unidade por pedido!\nSeu pedido foi alterado para: 1 Taça de vinho");
				vinho = 1;
			}
			if(bolo > 1) {
				System.out.println("As fatias de bolo estão limitadas a uma unidade por pedido!\nSeu pedido foi alterado para: 1 fatia de bolo");
				torradas = 1;
			}
			if (invalidasNoite>0){
				System.out.println("Pedido final: \nBife: "+bife+"\nPorções de batata: "+batatas+"\nTaça de vinho: "+vinho+"\nFatias de bolo: "+bolo+"\n"+invalidasNoite+" Opções inválidas.\nAguarde enquanto preparamos seu pedido e bom apetite!");
			}
			else {
			System.out.println("Pedido final: \nBife: "+bife+"\nPorções de batata: "+batatas+"\nTaça de vinho: "+vinho+"\nFatias de bolo: "+bolo
					+ "\nAguarde enquanto preparamos seu pedido e bom apetite!");
			}
			break;
			
		default: System.out.println("Opção não reconhecida");  // caso a opçção de horario não seja compativel com "Manhã" OU "Noite", será retornado uma mensagem de opção desconhecida e a solução tem sua execução encerrada
		break;
		}
	}

}
