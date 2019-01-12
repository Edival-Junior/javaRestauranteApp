package main;

import java.util.Scanner;

public class OrdensDeRestauranteOO {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		pedidoRestaurante pedido = new pedidoRestaurante();
		System.out.println("Olá, digite seu nome para iniciar o seu pedido!");
		System.out.print("Seu nome: ");
		String nome = scan.next();
		nome = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
		pedido.setNomeCliente(nome);
		System.out.println("Olá "+pedido.getNomeCliente()+", \nPara ver fazer seu pedido digite \"Manhã\" para os pratos matinais e \"Noite\" para os pratos noturnos.");
		pedido.setHorario(scan.next());
	
		try {
			if(!pedido.getHorario().equalsIgnoreCase("Noite")) {
				char[] hora = pedido.getHorario().toCharArray();
				hora[4] = 'ã';
				pedido.setHorario(new String(hora)); 
			}
			String horaCapitalizada = pedido.getHorario();
			horaCapitalizada = horaCapitalizada.substring(0, 1).toUpperCase() + horaCapitalizada.substring(1).toLowerCase(); 
			pedido.setHorario(horaCapitalizada);
		} catch (Exception erro) {
			System.out.println("Erro encontrado: "+erro);
			erro.printStackTrace();
		}
		System.out.println(pedido.getHorario());
		
		switch (pedido.getHorario()) {
		case "Manhã":
			pedido.setPratoPrincipal("Ovos");
			pedido.setAcompanhamento("Torradas");
			pedido.setBebida("Xicara de Café");
			
			System.out.println("Pratos matinais");

			break;

		case "Noite":
			
			pedido.setPratoPrincipal("Bife");
			pedido.setAcompanhamento("Porção de Batatas");
			pedido.setBebida("Taça de vinho");
			pedido.setSobremesa("Fatia de bolo");
			
			System.out.println("Pratos noturnos");
			break;
		default:
			break;
		}
		
		
		try {
			System.out.println("1 - Principal: "+pedido.getPratoPrincipal()); 
			System.out.println("2 - Acompanhamento: "+pedido.getAcompanhamento());
			System.out.println("3 - Bebida: "+ pedido.getBebida());
			if(pedido.getHorario().equalsIgnoreCase("Manhã")) {
			System.out.println("Para solicitar seu pedido, Digite o numero refetente a opção desejada!\n"
					+ "APENAS a quantidade de xicaras de café pode ser maior que 1\n"
					+ "Exemplo de pedido: 1233 (Ovo, torradas e duas xicaras de café)");
			}else {
				System.out.println("4 - Sobremesa: "+pedido.getSobremesa());
				System.out.println("Para solicitar seu pedido, Digite o numero referente a opção desejada!"
						+ "\nA quantidade de porções de batata pode ser maior que 1!"
						+ "\nExemplo de pedido: 12234 (Bife, duas porções de batata, uma taça de vinho e um pedaço de bolo)");
			}
			String ordemCliente = scan.next();
			char[] ordens = ordemCliente.toCharArray();
			
			System.out.println("Lendo seu pedido...");
			
			Thread.sleep(ordens.length * 200);
			
			for(int i = 0 ; i <ordens.length ; i++ ) {
				
				switch (ordens[i]) {
					
					case '1':
						pedido.setQuantidadePratoPrincipal(pedido.getQuantidadePratoPrincipal() + 1 );
					break;
					
					case '2':
						pedido.setQuantidadeAcompanhamento(pedido.getQuantidadeAcompanhamento() + 1);
					break;
					
					case '3':
						pedido.setQuantidadeBebida(pedido.getQuantidadeBebida() + 1);
					break;
					
					case '4':
						if (pedido.getHorario().equalsIgnoreCase("Noite")) {
							pedido.setQuantidadeSobremesa(pedido.getQuantidadeSobremesa() + 1);
							break;
						}else {
							System.out.println("A opção: "+ ordens[i] +" não é reconhecida e será desconsiderada!");
							break;
						}
						
					
					default: 
						System.out.println("A opção: "+ ordens[i] +" não é reconhecida e será desconsiderada!"); ;
					break;  
					
				}
			}
			
			System.out.println("Verificando quantidades...");
			Thread.sleep(300);
			if (pedido.getHorario().equalsIgnoreCase("Manhã")) {
				
				if (pedido.getQuantidadePratoPrincipal() > 1 ) {
					System.out.println("Os pratos principais do periodo matutino estão restritos a uma unidade por pedido. "
							+ "\n Seu pedido será alterado!");
					pedido.setQuantidadePratoPrincipal(1);
					
				}
				
				if (pedido.getQuantidadeAcompanhamento() > 1  ) {
					System.out.println("Os  acompanhamentos do periodo matutino estão restritos a uma unidade por pedido. "
							+ "\n Seu pedido será alterado!");
					pedido.setQuantidadeAcompanhamento(1);
				}

			}	
			
			if (pedido.getHorario().equalsIgnoreCase("Noite")) {
				
				if (pedido.getQuantidadePratoPrincipal() > 1 ) {
					System.out.println("Os pratos principais do periodo noturno estão restritos a uma unidade por pedido. "
							+ "\n Seu pedido será alterado!");
					pedido.setQuantidadePratoPrincipal(1);
					
				}
				
				if (pedido.getQuantidadeBebida() > 1  ) {
					System.out.println("As taças de vinho do periodo noturno estão restritas a uma unidade por pedido. "
							+ "\n Seu pedido será alterado!");
					pedido.setQuantidadeBebida(1);
				}

				if (pedido.getQuantidadeSobremesa() > 1  ) {
					System.out.println("As sobremesas do periodo noturno estão restritas a uma unidade por pedido. "
							+ "\n Seu pedido será alterado!");
					pedido.setQuantidadeSobremesa(1);
				}

			}
		}
		
		catch(Exception ex) { System.out.println("Erro: " +ex); }
		
		finally { scan.close(); }
		
		System.out.println("Pedido finalizado! "
						+ "\nSeu pedido foi: "
						+ "\n"+ pedido.getQuantidadePratoPrincipal() +" "+ pedido.getPratoPrincipal()
						+ "\n"+ pedido.getQuantidadeAcompanhamento() +" "+ pedido.getAcompanhamento()
						+ "\n"+ pedido.getQuantidadeBebida() +" "+ pedido.getBebida());
		if (pedido.getHorario().equalsIgnoreCase("Noite")) {
			System.out.println(pedido.getQuantidadeSobremesa() +" "+ pedido.getSobremesa());
		}
		System.out.println("Aguarde enquanto preparamos seu pedido.");
	}
}
