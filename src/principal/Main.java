package principal;
import view.Menu;

public class Main {

	public static void main(String[] args) {
		 // Cria o objeto do Menu
        Menu menuSistema = new Menu();
        
        // 1. Mostra a Capa com os nomes
        menuSistema.exibirCapa();
        
        // 2. Inicia o loop do programa principal
        menuSistema.iniciarMenuPrincipal();
	}

}
