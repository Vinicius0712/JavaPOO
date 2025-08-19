package dna;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.FileReader;

public class dna_validation {
	public static void main(String[] args) {
		for (int g = 0; g <= 9; g++) {
			System.out.print("Arquivo "+ g);
			String caminho = "C:\\arquivosDNA\\dna-"+ g +".txt";
			
	        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
	            String linha;
	            int j = 0;
	            String conteudo = "";
	            int fitas_validas = 0;
	            int fitas_invalidas = 0;
	            String linhas_invalidas = "[";
	            while ((linha = br.readLine()) != null) {
	                String fita_replica = "";
	                
	                boolean error = false;
	                for (int i = 0; i < linha.length(); i++) {
	                    switch (linha.charAt(i)) {
	                    default:
	                        error = true;
	                    case 'A':
	                        fita_replica += 'T';
	                        break;
	                    case 'T':
	                        fita_replica += 'A';
	                        break;
	                    case 'C':
	                        fita_replica += 'G';
	                        break;
	                    case 'G':
	                        fita_replica += 'C';
	                        break;
	                    }
	                    if (error) {
	                        break;
	                    }
	                }
	                
	                if (error) {
	                    fitas_invalidas++;
	                    conteudo += "***FITA INVALIDA - " + linha + "\n";
	                    linhas_invalidas += (j+1) + ",";
	                } else {
	                    fitas_validas++;
	                    conteudo += fita_replica + "\n";
	                }
	                j++;
	            }
	            linhas_invalidas += "]";
	            System.out.print("\nTotal de fitas: "+ (fitas_validas + fitas_invalidas)
	                		+"\nTotal de fitas válidas: "+ fitas_validas
	                		+"\nTotal de fitas inválidas: "+ fitas_invalidas
	                		+"\nLinhas inválidas: "+ linhas_invalidas);
	            
	            File caminhoArquivo = new File("DNA.text");


	            try (FileWriter writer = new FileWriter(caminhoArquivo, false)) {
	                writer.write(conteudo);
	                System.out.println("Arquivo criado com sucesso!");

	                if (caminhoArquivo.exists()) {
	                    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) { 
	                        Desktop.getDesktop().browse(caminhoArquivo.toURI());
	                    } else {
	                        System.out.println("Ação BROWSE não é suportada neste ambiente.");
	                    }
	                } else {
	                    System.out.println("Arquivo HTML não encontrado.");
	                }
	            } catch (IOException e) {
	                System.out.println("Ocorreu um erro ao criar/abrir o arquivo: " + e.getMessage());
	            }
	        } catch (IOException e) {
	            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
	        }
		}
		
	}
}
