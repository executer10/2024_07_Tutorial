import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//기본 CRUD 활용도
public class CRUD_Main3 {
	public static void main(String[] args) {
		
		System.out.println("==프로그램 시작==");
		Scanner scanner = new Scanner(System.in);
		
		List<Article> articles = new ArrayList<>();
		int lastArticleId = 1;
		while(true) {
			System.out.printf("명령어 : ");
			String cmd = scanner.nextLine().trim();			//양끝 공백 제거
			
			System.out.println("cmd = " + cmd);
			
			if(cmd.equals("exit")) {
				break;
			}

			if(cmd.length()==0) {
				System.out.println("명령어를 입력해주세요.");
				continue;									//반복문을 종료하는것이 아닌, 다음 반복문을 실행함
			}
			
			if(cmd.equals("article write")) {
				System.out.printf("제목 : ");
				String title = scanner.nextLine().trim();
				System.out.printf("내용 : ");
				String body = scanner.nextLine().trim();
				
				articles.add(new Article(lastArticleId, title, body));
				
				System.out.println(lastArticleId + "번 글이 생성되었습니다.");
				lastArticleId++;
				
			}
			
			else if(cmd.equals("article list")){
				if(articles.size() == 0) {
					System.out.println("게시글이 없습니다.");
					continue;
				}
				System.out.println("번호	|	제목");
				for(int i=articles.size()-1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d	|	%s\n", article.id, article.title, article.body);
				}
			}
			
			else if(cmd.startsWith("article detail ")) {
				String[] cmdBits = cmd.split(" ");
				int id = 0;
				
				try {
					id = Integer.parseInt(cmdBits[2]);
				} 
				catch (NumberFormatException e) {
					System.out.println("명령어가 올바르지 않습니다.");
					continue;
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
				Article foundArticle = null;
				
				for(Article article : articles) {
					if(article.id == id) {
						foundArticle = article;
						break;
					}
				}

				if(foundArticle == null) {
					System.out.println(id + "번 게시물이 없습니다.");
					continue;
				}
				
				System.out.println("번호 | " + foundArticle.id);
				System.out.println("제목 | " + foundArticle.title);
				System.out.println("내용 | " + foundArticle.body);
			}
			
			else if(cmd.startsWith("article delete ")) {
				String[] cmdBits = cmd.split(" ");
				int id = 0;
				
				try {
					id = Integer.parseInt(cmdBits[2]);
				} 
				catch (NumberFormatException e) {
					System.out.println("명령어가 올바르지 않습니다.");
					continue;
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
				Article foundArticle = null;
				
				for(Article article : articles) {
					if(article.id == id) {
						foundArticle = article;
						break;
					}
				}
				
				if(foundArticle == null) {
					System.out.println(id + "번 게시물이 없습니다.");
					continue;
				}

				int foundIndex = -1;
				
				int indexId = 0;

				for(Article article : articles) {
					if(article.id == id) {
						foundIndex = indexId;
						break;
					}
					indexId++;
				}
				
//				for(int i = 0; i< articles.size();i++) {
//					Article article = articles.get(i);
//					if(article.id == id) {
//						foundIndex = i;
//						break;
//					}
//				}
				
				articles.remove(foundArticle);
//				articles.remove(foundIndex);
				
				System.out.println(id + "번 게시물이 삭제되었습니다.");
			}
			
			else if(cmd.startsWith("article modify ")) {
				String[] cmdBits = cmd.split(" ");
				int id = 0;
				
				try {
					id = Integer.parseInt(cmdBits[2]);
				} 
				catch (NumberFormatException e) {
					System.out.println("명령어가 올바르지 않습니다.");
					continue;
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
				Article foundArticle = null;
				
				for(Article article : articles) {
					if(article.id == id) {
						foundArticle = article;
						break;
					}
				}
			
				if(foundArticle == null) {
					System.out.println(id + "번 게시물이 없습니다.");
					continue;
				}
				
				System.out.printf("제목 : ");
				String title = scanner.nextLine().trim();
				System.out.printf("내용 : ");
				String body = scanner.nextLine().trim();

				foundArticle.title = title;
				foundArticle.body = body;
				
				System.out.println(id + "번 게시물이 수정되었습니다.");
				
			}
			else {
				System.out.println("존재하지 않는 명령어 입니다.");
			}
			
		}
		scanner.close();
		System.out.println("==프로그램 끝==");
	}
}

class Article{
	int id;
	String title;
	String body;
	
	Article(int id, String title, String body){
		this.id = id;
		this.title = title;
		this.body = body;
	}
}
