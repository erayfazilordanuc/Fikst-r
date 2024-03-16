import java.util.*;

public class roundMaker {
    
        int numberOfTeams; 

        List<String[]> rounds = new ArrayList<>();
        
        public void make(){
    
        Scanner in = new Scanner(System.in);
    
        ArrayList<String> teams = new ArrayList<String>();
    
        System.out.print("\nTakım sayısını giriniz : ");
    
        this.numberOfTeams = in.nextInt();
    
        for(int i=0; i<this.numberOfTeams; i++){
    
            System.out.print("\nTakım adını giriniz : ");
            teams.add(in.next()); 
    
        }
    
        if(this.numberOfTeams % 2 != 0){
            this.numberOfTeams++;
            teams.add("Bay");
        }

        this.rounds = maker(teams);
    
        }

        public void get(int round){

            if(rounds.get(round-1) != null){

            for(String i: rounds.get(round-1)){
                
                System.out.print("\n" + i + " ");
        
            }
    
            System.out.println(" ");

            }

        }

        public void print(){

            for(String[] i: this.rounds){
                for(String j: i){
                
                    System.out.print("\n" + j + " ");
        
                }
    
                System.out.println(" ");
    
            }
            
            System.out.println(" ");

        }
    
        public List<String[]> maker(ArrayList<String> teams){
            
            List<String[]> rounds = new ArrayList<>();
    
            Random randoms = new Random();
    
            int[][] allCombinations = new int[this.numberOfTeams][this.numberOfTeams];    
    
            for(int i=0; i<this.numberOfTeams; i++){
                allCombinations[i][i] = 1;
            }

            int numOfRounds = (this.numberOfTeams*(this.numberOfTeams-1))/(this.numberOfTeams/2);

            for(int a=0; a<numOfRounds; a++){
            
            int[] whoDid = new int[this.numberOfTeams];

            String[] b = new String[this.numberOfTeams/2];
    
            for(int y=0; y<b.length; y++){
    
            int rs1 = randoms.nextInt(this.numberOfTeams);
    
            int rs2 = randoms.nextInt(this.numberOfTeams);

            boolean whoDidState = false;
    
            for(int s=0; s<whoDid.length; s++){

                if(whoDid[s] == 0){
                    whoDidState = true;
                    break;
                }

            }

            boolean allCombinatonsState = false;
    
            for(int s=0; s<allCombinations.length; s++){
                for(int f=0; f<allCombinations[s].length; f++){
                if(allCombinations[s][f] == 0){
                    allCombinatonsState = true;
                    break;
                }
            }

            }
 
            if(whoDidState && allCombinatonsState){

            while(allCombinations[rs1][rs2] == 1 || whoDid[rs1] == 1 || whoDid[rs2] == 1){
    
                rs1 = randoms.nextInt(this.numberOfTeams);
                rs2 = randoms.nextInt(this.numberOfTeams);

                System.out.println(rs1 + " " + rs2);
    
            }
            
            b[y] = teams.get(rs1) + " vs " + teams.get(rs2);
    
                allCombinations[rs1][rs2] = 1;

                whoDid[rs1] = whoDid[rs2] = 1;

            }
    
            }
    
            rounds.add(b);
    
            }

            return rounds;
    
        }
    
    }
    