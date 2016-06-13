package filereading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.lang.String;

public class Main {

	public static class Attribute {
		
		public Attribute(String word, int counter)
		{
			this.word = word;
			this.counter = counter;
		}
		
		public String word;
		public int counter;
	}
	
	 //public static String path = "C:/Users/Leonardo Soares Giro/Downloads/movie_review_dataset/part1/pos";
	//public static String path = "C:/Users/Leonardo Soares Giro/Downloads/movie_review_dataset/part2/pos";
	//public static String path = "C:/Users/Leonardo Soares Giro/Downloads/movie_review_dataset/part1/neg";
	public static String path = "C:/Users/Leonardo Soares Giro/Downloads/movie_review_dataset/part2/neg";
	
	public static ArrayList<String> reviews = new ArrayList<String>();

	//Lower case e sem palavras inuteis
	public static ArrayList<String> alteredReviews = new ArrayList<String>();

	//Candidatos a atributos
	public static ArrayList<Attribute> candidates = new ArrayList<Attribute>();

	//Lista de palavras inuteis
	public static ArrayList<String> uselessWords = new ArrayList<String>();
	
	public static ArrayList<String> meusLindos = new ArrayList<String>();
	
	public static void defineAttributes()
	{	/*
		//atributos negativos - Primeiro
		meusLindos.add("worst");
		meusLindos.add("minutes");
		meusLindos.add("guy");
		meusLindos.add("least");
		meusLindos.add("script");
		meusLindos.add("isnt");
		meusLindos.add("theres");
		meusLindos.add("whole");
		meusLindos.add("point");
		meusLindos.add("original");
		meusLindos.add("might");
		meusLindos.add("far");
		meusLindos.add("interesting");
		meusLindos.add("action");
		meusLindos.add("poor");
		meusLindos.add("kind");
		meusLindos.add("probably");
		meusLindos.add("trying");
		meusLindos.add("awful");
		meusLindos.add("stupid");
		meusLindos.add("terrible");
		meusLindos.add("boring");
		meusLindos.add("effects");
		meusLindos.add("maybe");
		meusLindos.add("believe");
		meusLindos.add("money");
		meusLindos.add("reason");
		
		//atributos positivos - Primeiro
		meusLindos.add("world");
		meusLindos.add("both");
		meusLindos.add("young");
		meusLindos.add("music");
		meusLindos.add("always");
		meusLindos.add("own");
		meusLindos.add("may");
		meusLindos.add("between");
		meusLindos.add("role");
		meusLindos.add("series");
		meusLindos.add("performance");
		meusLindos.add("comedy");
		meusLindos.add("times");
		meusLindos.add("excellent");
		meusLindos.add("each");
		meusLindos.add("war");
		meusLindos.add("family");
		meusLindos.add("fun");
		meusLindos.add("bit");
		meusLindos.add("dvd");
		meusLindos.add("feel");
		meusLindos.add("played");
		meusLindos.add("especially");
		meusLindos.add("shows");
		meusLindos.add("last");
		meusLindos.add("tv");
		meusLindos.add("beautiful");
		meusLindos.add("difference");	
		
		*/
		
		/*
		// SEGUNDA LEVA 
		//Positivos - Segundo set
		meusLindos.add("performance");
		meusLindos.add("excellent");
		meusLindos.add("each");
		meusLindos.add("war");
		meusLindos.add("family");
		meusLindos.add("dvd");
		meusLindos.add("especially");
		meusLindos.add("shows");
		meusLindos.add("beautiful");
		meusLindos.add("different");
		meusLindos.add("job");
		meusLindos.add("true");
		meusLindos.add("wonderful");
		meusLindos.add("play");
		meusLindos.add("plays");
		meusLindos.add("day");
		meusLindos.add("together");
		meusLindos.add("later");
		meusLindos.add("american");
		//meusLindos.add("takes");
		meusLindos.add("during");
		meusLindos.add("perfect");
		meusLindos.add("loved");
		meusLindos.add("death");
		meusLindos.add("classic");
		meusLindos.add("performances");
		meusLindos.add("along");
		meusLindos.add("seeing");
		meusLindos.add("recommend");
		meusLindos.add("black");
		meusLindos.add("enjoy");
		meusLindos.add("short");
		meusLindos.add("wife");
		meusLindos.add("human");
		meusLindos.add("definitely");
		meusLindos.add("night");
		meusLindos.add("home");
		meusLindos.add("truly");
		meusLindos.add("fan");
		meusLindos.add("nice");
		
		//Negativos - Segundo set
		meusLindos.add("worst");
		meusLindos.add("minutes");
		meusLindos.add("script");
		meusLindos.add("poor");
		meusLindos.add("trying");
		meusLindos.add("awful");
		meusLindos.add("stupid");
		meusLindos.add("terrible");
		meusLindos.add("boring");
		meusLindos.add("effects");
		meusLindos.add("maybe");
		meusLindos.add("money");
		meusLindos.add("reason");
		meusLindos.add("instead");
		meusLindos.add("looks");
		meusLindos.add("wasnt");
		meusLindos.add("book");
		meusLindos.add("idea");
		meusLindos.add("waste");
		meusLindos.add("completely");
		meusLindos.add("worse");
		meusLindos.add("else");
		meusLindos.add("half");
		meusLindos.add("said");
		meusLindos.add("left");
		meusLindos.add("horrible");
		meusLindos.add("shot");
		meusLindos.add("either");
		meusLindos.add("supposed");
		meusLindos.add("simply");
		meusLindos.add("budget");
		meusLindos.add("wrong");
		meusLindos.add("audience");
		meusLindos.add("couldnt");
		meusLindos.add("oh");
		meusLindos.add("mean");
	    */
		
		/*// TERCEIRA LEVA
		meusLindos.add("performance");
		meusLindos.add("excellent");
		meusLindos.add("each");
		meusLindos.add("war");
		meusLindos.add("family");
		meusLindos.add("dvd");
		meusLindos.add("especially");
		meusLindos.add("shows");
		meusLindos.add("beautiful");
		meusLindos.add("different");
		meusLindos.add("job");
		meusLindos.add("true");
		meusLindos.add("wonderful");
		meusLindos.add("play");
		meusLindos.add("plays");
		meusLindos.add("day");
		meusLindos.add("together");
		meusLindos.add("later");
		meusLindos.add("american");
		meusLindos.add("during");
		meusLindos.add("perfect");
		meusLindos.add("loved");
		meusLindos.add("death");
		meusLindos.add("classic");
		meusLindos.add("performances");
		meusLindos.add("along");
		meusLindos.add("seeing");
		meusLindos.add("recommend");
		meusLindos.add("black");
		meusLindos.add("enjoy");
		meusLindos.add("short");
		meusLindos.add("wife");
		meusLindos.add("human");
		meusLindos.add("definitely");
		meusLindos.add("night");
		meusLindos.add("home");
		meusLindos.add("truly");
		meusLindos.add("fan");
		meusLindos.add("nice");
		
		//Negativos - Segundo set
		meusLindos.add("worst");
		meusLindos.add("minutes");
		meusLindos.add("script");
		meusLindos.add("poor");
		meusLindos.add("trying");
		meusLindos.add("awful");
		meusLindos.add("stupid");
		meusLindos.add("terrible");
		meusLindos.add("boring");
		meusLindos.add("effects");
		meusLindos.add("maybe");
		meusLindos.add("money");
		meusLindos.add("reason");
		meusLindos.add("instead");
		meusLindos.add("looks");
		meusLindos.add("wasnt");
		meusLindos.add("book");
		meusLindos.add("idea");
		meusLindos.add("waste");
		meusLindos.add("completely");
		meusLindos.add("worse");
		meusLindos.add("else");
		meusLindos.add("half");
		meusLindos.add("said");
		meusLindos.add("left");
		meusLindos.add("horrible");
		meusLindos.add("shot");
		meusLindos.add("either");
		meusLindos.add("supposed");
		meusLindos.add("simply");
		meusLindos.add("budget");
		meusLindos.add("wrong");
		meusLindos.add("audience");
		meusLindos.add("couldnt");
		meusLindos.add("oh");
		meusLindos.add("mean");
		meusLindos.add("least");
		meusLindos.add("crap");
		meusLindos.add("annoying");
		meusLindos.add("ridiculous");
		meusLindos.add("low"); */
		
		// QUARTA LEVA
		// Positivos
		meusLindos.add("performance");
		meusLindos.add("excellent");
		meusLindos.add("each");
		meusLindos.add("war");
		meusLindos.add("family");
		meusLindos.add("dvd");
		meusLindos.add("especially");
		meusLindos.add("shows");
		meusLindos.add("beautiful");
		meusLindos.add("different");
		meusLindos.add("job");
		meusLindos.add("true");
		meusLindos.add("wonderful");
		meusLindos.add("play");
		meusLindos.add("plays");
		meusLindos.add("day");
		meusLindos.add("together");
		meusLindos.add("later");
		meusLindos.add("american");
		meusLindos.add("during");
		meusLindos.add("perfect");
		meusLindos.add("loved");
		meusLindos.add("death");
		meusLindos.add("classic");
		meusLindos.add("performances");
		meusLindos.add("along");
		meusLindos.add("seeing");
		meusLindos.add("recommend");
		meusLindos.add("black");
		meusLindos.add("enjoy");
		meusLindos.add("short");
		meusLindos.add("wife");
		meusLindos.add("human");
		meusLindos.add("definitely");
		meusLindos.add("night");
		meusLindos.add("home");
		meusLindos.add("truly");
		meusLindos.add("fan");
		meusLindos.add("nice");
		meusLindos.add("original");
		//Negativos
		meusLindos.add("worst");
		meusLindos.add("minutes");
		meusLindos.add("script");
		meusLindos.add("poor");
		meusLindos.add("trying");
		meusLindos.add("awful");
		meusLindos.add("stupid");
		meusLindos.add("terrible");
		meusLindos.add("boring");
		meusLindos.add("effects");
		meusLindos.add("maybe");
		meusLindos.add("money");
		meusLindos.add("reason");
		meusLindos.add("instead");
		meusLindos.add("looks");
		meusLindos.add("wasnt");
		meusLindos.add("book");
		meusLindos.add("idea");
		meusLindos.add("waste");
		meusLindos.add("completely");
		meusLindos.add("worse");
		meusLindos.add("else");
		meusLindos.add("half");
		meusLindos.add("said");
		meusLindos.add("left");
		meusLindos.add("horrible");
		meusLindos.add("shot");
		meusLindos.add("either");
		meusLindos.add("supposed");
		meusLindos.add("simply");
		meusLindos.add("budget");
		meusLindos.add("wrong");
		meusLindos.add("audience");
		meusLindos.add("couldnt");
		meusLindos.add("oh");
		meusLindos.add("mean");
		meusLindos.add("least");
		meusLindos.add("crap");
		meusLindos.add("annoying");
		meusLindos.add("ridiculous");
		meusLindos.add("low"); 
		meusLindos.add("poorly");
		meusLindos.add("lame");
		meusLindos.add("dull");
		meusLindos.add("cheap");
		meusLindos.add("avoid");
		meusLindos.add("unfortunately");
		meusLindos.add("wasted");
		meusLindos.add("badly");
		meusLindos.add("mess");
		meusLindos.add("problem");
		meusLindos.add("attempt");
		meusLindos.add("sorry");
		meusLindos.add("predictable");
		meusLindos.add("pointless");
		meusLindos.add("dumb");
		meusLindos.add("pathetic");
		meusLindos.add("fail");
		meusLindos.add("fails");
		
	}
	/**
	 * Define palavras inúteis
	 */
	public static void defineUseless()
	{
		//Definite pronouns		
		uselessWords.add("i");
		uselessWords.add("you");
		uselessWords.add("he");
		uselessWords.add("she");
		uselessWords.add("it");
		uselessWords.add("we");
		uselessWords.add("you");
		uselessWords.add("they");
		uselessWords.add("me");
		uselessWords.add("him");
		uselessWords.add("her");
		uselessWords.add("us");
		uselessWords.add("them");
		uselessWords.add("my");
		uselessWords.add("your");
		uselessWords.add("his");
		uselessWords.add("its");
		uselessWords.add("our");
		uselessWords.add("their");
		uselessWords.add("mine");
		uselessWords.add("yours");
		uselessWords.add("hers");
		uselessWords.add("ours");
		uselessWords.add("theirs");
		uselessWords.add("myself");
		uselessWords.add("yourself");
		uselessWords.add("himself");
		uselessWords.add("herself");
		uselessWords.add("itself");
		uselessWords.add("ourselves");
		uselessWords.add("themselves");	
		uselessWords.add("yourselves");
		
		//Indefinite pronouns
		uselessWords.add("everyone");
		uselessWords.add("everybody");
		uselessWords.add("someone");
		uselessWords.add("somebody");
		uselessWords.add("anyone");
		uselessWords.add("anybody");
		uselessWords.add("nobody");
		uselessWords.add("everywhere");
		uselessWords.add("somewhere");
		uselessWords.add("anywhere");
		uselessWords.add("nowhere");
		uselessWords.add("everything");
		uselessWords.add("something");
		uselessWords.add("anything");
		uselessWords.add("nothing");
		
		//Determiners
		uselessWords.add("the");
		uselessWords.add("a");
		uselessWords.add("an");
		uselessWords.add("this");
		uselessWords.add("that");
		uselessWords.add("these");
		uselessWords.add("those");

		//Numbers
		uselessWords.add("0");
		uselessWords.add("1");
		uselessWords.add("2");
		uselessWords.add("3");
		uselessWords.add("4");
		uselessWords.add("5");
		uselessWords.add("6");
		uselessWords.add("7");
		uselessWords.add("8");
		uselessWords.add("9");
		
		//Symbols
		uselessWords.add(".");
		uselessWords.add("?");
		uselessWords.add("-");
		uselessWords.add("!");
		uselessWords.add(",");
		uselessWords.add("(");
		uselessWords.add(")");
		uselessWords.add(">");
		uselessWords.add("<");
		uselessWords.add("@");
		uselessWords.add("#");
		uselessWords.add("$");
		uselessWords.add("%");
		uselessWords.add("&");
		uselessWords.add("*");
		uselessWords.add("_");
		
		//Alphabet (A already included earlier)
		uselessWords.add("b");
		uselessWords.add("c");
		uselessWords.add("d");
		uselessWords.add("e");
		uselessWords.add("f");
		uselessWords.add("g");
		uselessWords.add("h");
		uselessWords.add("j");
		uselessWords.add("k");
		uselessWords.add("l");
		uselessWords.add("m");
		uselessWords.add("n");
		uselessWords.add("o");
		uselessWords.add("p");
		uselessWords.add("q");
		uselessWords.add("r");
		uselessWords.add("s");
		uselessWords.add("t");
		uselessWords.add("u");
		uselessWords.add("v");
		uselessWords.add("x");
		uselessWords.add("y");
		uselessWords.add("w");
		uselessWords.add("z");
		
		//Conjunctions
		uselessWords.add("and");
		uselessWords.add("but");
		uselessWords.add("or");
		uselessWords.add("yet");
		uselessWords.add("for");
		uselessWords.add("nor");
		uselessWords.add("so");
		uselessWords.add("if");
		uselessWords.add("after");
		uselessWords.add("although");
		uselessWords.add("as");
		uselessWords.add("because");
		uselessWords.add("before");
		uselessWords.add("once");
		uselessWords.add("since");
		uselessWords.add("until");
		uselessWords.add("while");
		uselessWords.add("unless");
		uselessWords.add("when");
		uselessWords.add("where");
		uselessWords.add("wherever");
		
		// Primeira "leva": Palavras encontradas por contagem (muito encontradas tanto em pos quanto neg) PRI
		uselessWords.add("br");
		uselessWords.add("of");
		uselessWords.add("to");
		uselessWords.add("is");
		uselessWords.add("in");
		uselessWords.add("was");
		uselessWords.add("with");
		uselessWords.add("on");
		uselessWords.add("are");
		uselessWords.add("not");
		uselessWords.add("be");
		uselessWords.add("at");
		uselessWords.add("all");
		uselessWords.add("film");
		uselessWords.add("movie");
		uselessWords.add("from");
		uselessWords.add("");
		uselessWords.add("by");
		uselessWords.add("one");
		uselessWords.add("have");
		uselessWords.add("out");
		uselessWords.add("what");
		uselessWords.add("some");
		uselessWords.add("just");
		
		// Segunda "leva" : Palavras encontradas por contagem (muito encontradas tanto em pos quanto neg) 
		uselessWords.add("like");
		uselessWords.add("who");
		uselessWords.add("about");
		uselessWords.add("has");
		uselessWords.add("just");
		uselessWords.add("there");
		uselessWords.add("no");
		uselessWords.add("even");
		uselessWords.add("good");
		uselessWords.add("would");
		uselessWords.add("only");
		uselessWords.add("up");
		uselessWords.add("were");
		uselessWords.add("really");
		uselessWords.add("had");
		uselessWords.add("more");
		uselessWords.add("very");
		uselessWords.add("time");
		uselessWords.add("which");
		uselessWords.add("can");
		uselessWords.add("see");
		uselessWords.add("movies");
		
		// "terceira" leva : Palavras encontradas por contagem (muito encontradas tanto em pos quanto neg)
		uselessWords.add("characters");
		uselessWords.add("character");
		uselessWords.add("other");
		uselessWords.add("story");
		uselessWords.add("also");
		uselessWords.add("will");
		uselessWords.add("much");
		uselessWords.add("than");
		uselessWords.add("how");
		uselessWords.add("made");
		uselessWords.add("people");
		uselessWords.add("into");
		uselessWords.add("films");
		uselessWords.add("how");
		uselessWords.add("being");
		uselessWords.add("scene");
		uselessWords.add("do");
		uselessWords.add("dont");
		uselessWords.add("get");
		uselessWords.add("been");
		uselessWords.add("how");
		uselessWords.add("then");
		uselessWords.add("first");
		uselessWords.add("too");
		uselessWords.add("well");
		uselessWords.add("way");
		uselessWords.add("watch");
		uselessWords.add("did");
		uselessWords.add("know");
		uselessWords.add("seen");
		uselessWords.add("better");
		uselessWords.add("ever");
		uselessWords.add("two");
		uselessWords.add("many");
		uselessWords.add("say");
		uselessWords.add("scenes");
		uselessWords.add("little");
		uselessWords.add("does");
		uselessWords.add("im");
		uselessWords.add("over");
		uselessWords.add("end");
		uselessWords.add("here");
		uselessWords.add("go");
		uselessWords.add("such");
		uselessWords.add("through");
		uselessWords.add("look");
		uselessWords.add("now");
		uselessWords.add("back");
		uselessWords.add("every");
		
		
		//quarta leva
		uselessWords.add("great");
		uselessWords.add("most");
		uselessWords.add("love");
		uselessWords.add("best");
		uselessWords.add("life");
		uselessWords.add("think");
		uselessWords.add("show");
		uselessWords.add("make");
		uselessWords.add("never");
		uselessWords.add("still");
		uselessWords.add("could");
		uselessWords.add("any");
		uselessWords.add("man");
		uselessWords.add("years");
		uselessWords.add("makes");
		uselessWords.add("real");
		uselessWords.add("acting");
		uselessWords.add("plot");
		uselessWords.add("find");
		uselessWords.add("new");
		uselessWords.add("off");
		uselessWords.add("lot");
		uselessWords.add("though");
		uselessWords.add("funny");
		uselessWords.add("another");
		uselessWords.add("work");
		uselessWords.add("quite");
		uselessWords.add("same");
		uselessWords.add("again");
		uselessWords.add("cast");
		uselessWords.add("should");
		uselessWords.add("actors");
		uselessWords.add("part");
		uselessWords.add("old");
		uselessWords.add("watching");
		uselessWords.add("few");
		uselessWords.add("doesnt");
		uselessWords.add("things");
		uselessWords.add("saw");
		uselessWords.add("bad");
		uselessWords.add("going");
		uselessWords.add("take");
		uselessWords.add("thing");
		uselessWords.add("director");
		uselessWords.add("however");
		uselessWords.add("big");
		uselessWords.add("must");
		uselessWords.add("down");
		uselessWords.add("long");
		uselessWords.add("actually");
		uselessWords.add("ive");
		uselessWords.add("want");
		uselessWords.add("around");
		uselessWords.add("without");
		uselessWords.add("right");
		uselessWords.add("thought");
		uselessWords.add("almost");
		uselessWords.add("cant");
		uselessWords.add("come");
		uselessWords.add("seems");
		uselessWords.add("fact");
		uselessWords.add("horror");
		uselessWords.add("got");
		uselessWords.add("give");
		uselessWords.add("done");
		uselessWords.add("enough");
		uselessWords.add("pretty");
		uselessWords.add("gets");
		uselessWords.add("thats");
		uselessWords.add("am");

	}
	
	/**
	 * Procura candidatos a atributo
	 */
	public static void findAttributesCandidates ()
	{
		ArrayList<String> reviewWords;
		String[] reviewWordsVector;
		Attribute candidate;
		
		ArrayList<String> candidatesWords =  new ArrayList<String>();
		
		//Separa as palavras de cada review e remove palavras inúteis
		for(String review : alteredReviews)
		{
			//split retorna um vetor
			reviewWordsVector = review.split(", ");
			
			reviewWords = new ArrayList<String>(Arrays.asList(reviewWordsVector));
					
			//lê cada palavra da review em questão e adiciona na lista de candidatos a atributo
			for(int j=0; j < reviewWords.size(); j++)
			{	
				//Trata os reviews alterados para ver se há ainda special character, umas vez que se tornou string de novo
				if(containsSpecialCharacter(reviewWords.get(j)))
				{
					reviewWords.set(j, removeSpecialCharacters(reviewWords.get(j)));
				}
				
				//se candidates estiver vazia, insere o primeiro elemento
				if(candidates.isEmpty())
				{
					candidate = new Attribute(reviewWords.get(j), 1);
					candidates.add(candidate);
					candidatesWords.add(reviewWords.get(j));
				}
				else
				{
					// se candidates possui já a palavra, incrementa counter
					if(candidatesWords.contains(reviewWords.get(j)))
					{
						for(int i=0; i < candidates.size(); i++)
						{
							if(candidates.get(i).word.equals(reviewWords.get(j)))
							{
								candidates.get(i).counter++;
							}
						}
					}
					// se candidates não possui a palavra, insere a palavra
					else
					{
						candidate = new Attribute(reviewWords.get(j), 1);
						candidates.add(candidate);
						candidatesWords.add(reviewWords.get(j));
					}
				}
			}
		}
	}
	
	public static Comparator<Attribute> counterComparator = new Comparator<Attribute>() {
	public int compare(Attribute at1, Attribute at2) {             
	      return (at2.counter < at1.counter ? -1 : ((at2.counter == at1.counter) ? 0 : 1));           
	    } 
	};
	
	/**
	 * Ordena a lista de candidatos a atributo por counter.s
	 */
	public static void sortCandidatesByCounter()
	{
		candidates.sort(counterComparator);
		
		for(Attribute candidate : candidates)
		{
			System.out.println(candidate.word + "   " + candidate.counter);
		}
	}
	
	/**
	 * Faz a leitura dos arquivos de review e joga para a memória cada review, para um ArrayList
	 */
	public static void saveReviewsFromFiles ()
	{
		File folder = new File(path);
		
		File[] reviewsFolder = folder.listFiles();
		
		// Lê path de cada arquivo da pasta
		for (int i=0; i < reviewsFolder.length; i++)
			System.out.println(reviewsFolder[i]);
		
		// Guarda todas as reviews na lista.
				for(File i : reviewsFolder) {
					if (i.isFile()) {

						// Tentativa de ler os arquivos
						try {
							BufferedReader reader = new BufferedReader(new FileReader(i));

							// Salvando na lista de reviews
							reviews.add(reader.readLine());

							reader.close();
							
						} 
						catch (IOException x) {
							System.err.format("IOException: %s%n", x);
						}
						
						
					}
				}
	}
	
	/**
	 * Método básico de leitura de reviews
	 */
	public static void readReviewsFromMemory()
	{ 	
		ArrayList<String> reviewWords;
		ArrayList<String> arrayWithoutUseless;
		String[] reviewWordsVector;
		String alteredReview;
		int key;
		//Separa as palavras de cada review e remove palavras inúteis
		for(String review : reviews)
		{
			arrayWithoutUseless = new ArrayList<String>();
			//split retorna um vetor
			reviewWordsVector = review.split(" ");
			
			reviewWords = new ArrayList<String>(Arrays.asList(reviewWordsVector));
			
			//Passa todas as palavras para lowercase (facilita comparação)
			for(int i=0; i< reviewWords.size(); i++ )
			{
				reviewWords.set(i, reviewWords.get(i).toLowerCase());
			}
			
			//lê cada palavra da review em questão
			for(int j= 0 ; j < reviewWords.size() ; j++)
			{	
				key = 0;
				
				//Tira caracteres especiais das palavras, se a palavra contem
				if(containsSpecialCharacter(reviewWords.get(j)))
				{
					reviewWords.set(j, removeSpecialCharacters(reviewWords.get(j)));
				}
				
				//Copia palavras não inuteis para arrayWithoutUseless
				for(int w=0; (w < uselessWords.size()) && (key == 0) ; w++)
				{
					if(reviewWords.get(j).equals(uselessWords.get(w)))
					{
						key = 1;
					}
				}
				
				if(key == 0)
					arrayWithoutUseless.add(reviewWords.get(j));
				
			}
			
			alteredReview = new String();
			alteredReview = arrayWithoutUseless.toString();
			
			alteredReviews.add(alteredReview);
		}
	}
	
	public static boolean containsSpecialCharacter(String word)
	{
		ArrayList<String> characters = new ArrayList<String>();
		
		characters.add(".");
		characters.add(",");
		characters.add("[");
		characters.add("]");
		characters.add("(");
		characters.add(")");
		characters.add("'");
		characters.add("-");
		characters.add("<");
		characters.add(">");
		characters.add("*");
		characters.add(":");
		characters.add("/");
		characters.add("\\"); //backslash
		characters.add("?");
		characters.add("!");
		characters.add("\""); //quotes
		characters.add(";");
	
		for(int i=0; i < characters.size(); i++)
		{
			if(word.contains(characters.get(i)))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public static String removeSpecialCharacters(String word)
	{
		ArrayList<String> characters = new ArrayList<String>();
		String actual;
		
		characters.add(".");
		characters.add(",");
		characters.add("[");
		characters.add("]");
		characters.add("(");
		characters.add(")");
		characters.add("'");
		characters.add("-");
		characters.add("<");
		characters.add(">");
		characters.add("*");
		characters.add(":");
		characters.add("/");
		characters.add("\\"); //backslash
		characters.add("?");
		characters.add("!");
		characters.add("\""); //quotes
		characters.add(";");
	
		for(int i=0; i < characters.size(); i++)
		{
			actual = characters.get(i);
			
			if(word.contains(actual))
			{
				word = word.replace(actual, "");
			}
		}
		
		return word;
	}
	
	public static void writeArff() throws FileNotFoundException, UnsupportedEncodingException
	{
		PrintWriter arff = new PrintWriter("IA3.arff", "UTF-8");
		ArrayList<String> reviewWords;
		String[] reviewWordsVector;
		ArrayList<Attribute> attributes;
		
		int numberOfAttributes = 100;
		
		int occurrenceCounter = 0;
		
		arff.println("@relation reviews");
		arff.println("");
		
		for(int i=0; i < numberOfAttributes; i++)
		{
			arff.println("@attribute " + "'" + candidates.get(i).word + "' real");
		}
		
		arff.println("@attribute opinion {pos, neg}");
		arff.println("");
		arff.println("@data");
		
		for(String review : alteredReviews)
		{
			attributes = new ArrayList<Attribute>();
			
			//split retorna um vetor
			reviewWordsVector = review.split(", ");
			
			reviewWords = new ArrayList<String>(Arrays.asList(reviewWordsVector));
					
			//lê cada palavra da review em questão e adiciona na lista de candidatos a atributo
			for(int j=0; j < reviewWords.size(); j++)
			{	
				//Trata os reviews alterados para ver se há ainda special character, umas vez que se tornou string de novo
				if(containsSpecialCharacter(reviewWords.get(j)))
				{
					reviewWords.set(j, removeSpecialCharacters(reviewWords.get(j)));
				}
			}
			
			//Verifica para cada atributo quantas vezes ele é encontrado em cada review e incrementa o contador, caso haja
			for(int w=0; w < numberOfAttributes; w++)
			{
				occurrenceCounter = 0;
				
				for(int i=0; i < reviewWords.size(); i++)
				{
					if(candidates.get(w).word.equals(reviewWords.get(i)))
					{
						if(occurrenceCounter == 0)
						{
							attributes.add(w, new Attribute(reviewWords.get(i), 1));
							occurrenceCounter++;
						}
						else
						{
							attributes.get(w).counter++;
						}
					}
				}
				
				if(occurrenceCounter == 0)
					attributes.add(w, new Attribute(candidates.get(w).word, 0));
			}
			
			//Escreve no .arff o @data
			for(int z=0; z < numberOfAttributes; z++)
			{
				arff.print(attributes.get(z).counter + ",");
				
				if(z == (numberOfAttributes - 1))
				{
					arff.print("pos" + "\n");
				}
			}
		}
		
		arff.close();
	}
	
	public static void writeOfficialArff() throws FileNotFoundException, UnsupportedEncodingException
	{
		PrintWriter arff = new PrintWriter("IA3oficials.arff", "UTF-8");
		ArrayList<String> reviewWords;
		String[] reviewWordsVector;
		ArrayList<Attribute> attributes;
		
		int invalidReviewCounter = 0;
		
		int occurrenceCounter = 0;
		
		arff.println("@relation reviews");
		arff.println("");
		
		for(int i=0; i < meusLindos.size(); i++)
		{
			arff.println("@attribute " + "'" + meusLindos.get(i) + "' real");
		}
		
		arff.println("@attribute opinion {pos, neg}");
		arff.println("");
		arff.println("@data");
		
		for(String review : alteredReviews)
		{
			invalidReviewCounter = 0;
			attributes = new ArrayList<Attribute>();
			
			//split retorna um vetor
			reviewWordsVector = review.split(", ");
			
			reviewWords = new ArrayList<String>(Arrays.asList(reviewWordsVector));
					
			//lê cada palavra da review em questão e adiciona na lista de candidatos a atributo
			for(int j=0; j < reviewWords.size(); j++)
			{	
				//Trata os reviews alterados para ver se há ainda special character, umas vez que se tornou string de novo
				if(containsSpecialCharacter(reviewWords.get(j)))
				{
					reviewWords.set(j, removeSpecialCharacters(reviewWords.get(j)));
				}
			}
			
			//Verifica para cada atributo quantas vezes ele é encontrado em cada review e incrementa o contador, caso haja
			for(int w=0; w < meusLindos.size(); w++)
			{
				occurrenceCounter = 0;
				
				for(int i=0; i < reviewWords.size(); i++)
				{
					if(meusLindos.get(w).equals(reviewWords.get(i)))
					{
						if(occurrenceCounter == 0)
						{
							attributes.add(w, new Attribute(reviewWords.get(i), 1));
							occurrenceCounter++;
						}
						else
						{
							attributes.get(w).counter++;
						}
					}
				}
				
				if(occurrenceCounter == 0)
				{
					attributes.add(w, new Attribute(meusLindos.get(w), 0));
					invalidReviewCounter++;
				}
			}
			
			if(invalidReviewCounter != meusLindos.size())
			{
				//Escreve no .arff o @data
				for(int z=0; z < meusLindos.size(); z++)
				{
					arff.print(attributes.get(z).counter + ",");
					
					if(z == (meusLindos.size() - 1))
					{
						arff.print("neg" + "\n");
					}
				}
			}
		}
		
		arff.close();
	}
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		defineAttributes();
		
		System.out.println(">>>> Definindo palavras inuteis <<<<");
		defineUseless();
		System.out.println(">>>> Palavras inuteis definidas <<<<");
		
		System.out.println(">>>> Gravando reviews em memória <<<<");
		saveReviewsFromFiles();
		System.out.println(">>>> Reviews Salvos <<<<");
		
		System.out.println(">>>> Lendo reviews <<<<");
		readReviewsFromMemory();
		System.out.println(">>>> Reviews Lidos <<<<");
		
		System.out.println(">>>> Procurando candidatos a atributos<<<<");
		//findAttributesCandidates();
		System.out.println(">>>> Candidatos encontrados <<<<");
		
		System.out.println(">>>> Ordenando vetor de candidatos <<<<");
		//sortCandidatesByCounter();
		System.out.println(">>>> Vetor ordenado <<<<");
		
		System.out.println(">>>> Escrevendo .arff <<<<");
		//writeArff();
		System.out.println(">>>> .arff escrito <<<<");
		
		System.out.println(">>>> Finalizando  <<<<");
		
		
		writeOfficialArff();
	}

}
