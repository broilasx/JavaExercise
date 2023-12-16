public class Exercicio1 {
    public static void main(String[] args) {
        String URLs[] = {
                "https://www.dei.uc.pt/poao/exames",
                "http://www.scs.org/index.html",
                "https://www.nato.int/events",
                "https://www.btu.de/",
                "https://www.dei.uc.pt/poao/exames",
                "http://www.eth.ch/index.html",
                "http://www.osu.edu/"
        };
        String paises[][] = {
                {"pt", "Portugal"},
                {"org", "EUA"},
                {"fr", "França"},
                {"uk", "Reino Unido"},
                {"de", "Alemanha"},
                {"edu", "EUA"}
        };

        String[] links = extrairLink(URLs);
        quantDominios(links, paises);
    }
    //funcao que divide os items da lista pelos "/" e coloca o link principal por ex : www.dei.uc.pt como um item na lista links
    public static String[] extrairLink(String[] urls) {
        String[] links = new String[urls.length];

        for (int k = 0; k < urls.length; k++) {
            String[] dividido = urls[k].split("/");
            for (int i = 0; i < dividido.length; i++) {
                if (i == 2) {
                    String[] subDividido = dividido[i].split("\\.");
                    links[k] = subDividido[subDividido.length - 1];
                }
            }
        }
        return links;
    }

    public static void quantDominios(String[] links, String[][] paises) {
        int[] quantidade = new int[paises.length + 1]; // +1 para "outros"
        for (String dominio : links) {
            boolean contido = false;
            for (int i = 0; i < paises.length; i++) {
                if (dominio.equals(paises[i][0])) {
                    quantidade[i]++;
                    contido = true;
                    break;
                }
            }
            if (!contido) {
                quantidade[quantidade.length - 1]++;
            }
        }
        //Printar os paises e a quantidade de
        for (int i = 0; i < paises.length; i++) {
            for (int j = i + 1; j < paises.length; j++) {
                if (paises[i][1].equals(paises[j][1])) {
                    quantidade[i] += quantidade[j]; //se existirem mais
                    quantidade[j] = 0;
                }
            }
            if (quantidade[i] > 0) {
                System.out.println(paises[i][1] + ": " + quantidade[i]);
            }
        }
        System.out.println("Outro(s): " + quantidade[quantidade.length - 1]);
    }
}