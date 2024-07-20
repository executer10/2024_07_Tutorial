package com.koranIT.BAM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.koranIT.BAM.dto.Article;
import com.koranIT.BAM.util.Util;

public class App {
	private List<Article> articles;
	private int lastArticleId;

	public App(){		//main에 호출이 되어 있어서 public
		articles = new ArrayList<>();		//this.articles = 해당 클래스 안에서 만들어진 전역변수라서 가능(생략도 가능)
		lastArticleId = 1;
	}
	
	public void run(){	//main에 호출이 되어 있어서 public
		System.out.println("==프로그램 시작==");
		
		makeTestData();
		
		Scanner scanner = new Scanner(System.in);
		
		
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
				
				
				articles.add(new Article(lastArticleId, Util.getDateStr(), title, body, 0));
				
				System.out.println(lastArticleId + "번 글이 생성되었습니다.");
				lastArticleId++;
				
			}
			
			else if(cmd.startsWith("article list")){
				if(articles.size() == 0) {
					System.out.println("게시글이 없습니다.");
					continue;
				}
				
				String searchKeyword = cmd.substring("article list".length()).trim();		//글자를 원하는 방식대로 잘라내는 메서드(숫자 혹은 전체 문자 길이로 지정)
				
				List<Article> printArticles = articles;
				
				if(searchKeyword.length() > 0) {
					System.out.println("검색어 : " + searchKeyword);
					
					printArticles = new ArrayList<>();
					
					for(Article article : articles) {
						if(article.getTitle().contains(searchKeyword)) {
							printArticles.add(article);
						}
					}
					
					if(printArticles.size() == 0) {
						System.out.println("검색결과가 없습니다");
						continue;
					}
				}
				
				System.out.println("번호	|	제목  |	날짜		|	조회수");
				for(int i = printArticles.size() -1; i >= 0; i--) {
					Article article = printArticles.get(i);
					System.out.printf("%d	|	%s	%s		%d\n", article.getId(), article.getTitle(), article.getRegDate(), article.getViewCnt());
				}
			}
			
			else if(cmd.startsWith("article detail ")) {

				int id = getCmdNum(cmd);

				if(id == 0) {
					System.out.println("명령어가 올바르지 않습니다");
					continue;
				}
				
				Article foundArticle = getArticleById(id);

				if(foundArticle == null) {
					System.out.println(id + "번 게시물이 없습니다.");
					continue;
				}


				foundArticle.increaseViewCnt();
				
				System.out.println("번호 | " + foundArticle.getId());
				System.out.println("날짜 | " + foundArticle.getRegDate());
				System.out.println("제목 | " + foundArticle.getTitle());
				System.out.println("내용 | " + foundArticle.getBody());
				System.out.println("조회수 | " + foundArticle.getViewCnt());
			}
			
			else if(cmd.startsWith("article delete ")) {
				int id = getCmdNum(cmd);

				if(id == 0) {
					System.out.println("명령어가 올바르지 않습니다");
					continue;
				}
				
				Article foundArticle = getArticleById(id);

				if(foundArticle == null) {
					System.out.println(id + "번 게시물이 없습니다.");
					continue;
				}
				articles.remove(foundArticle);
				
				System.out.println(id + "번 게시물이 삭제되었습니다.");
			}
			
			else if(cmd.startsWith("article modify ")) {
				int id = getCmdNum(cmd);

				if(id == 0) {
					System.out.println("명령어가 올바르지 않습니다");
					continue;
				}
				
				Article foundArticle = getArticleById(id);

				if(foundArticle == null) {
					System.out.println(id + "번 게시물이 없습니다.");
					continue;
				}
				
				System.out.printf("제목 : ");
				String title = scanner.nextLine().trim();
				System.out.printf("내용 : ");
				String body = scanner.nextLine().trim();
				
				foundArticle.setTitle(title);	//foundArticle.title = title;
				foundArticle.setBody(body);		//foundArticle.body = body;
				
				System.out.println(id + "번 게시물이 수정되었습니다.");
				
			}
			
			else {
				System.out.println("존재하지 않는 명령어 입니다.");
			}
			
		}
		scanner.close();
		System.out.println("==프로그램 끝==");
	}
	private Article getArticleById(int id) {
		
		for(Article article : articles) {
			if(article.getId() == id) {
				return article;
			}
		}
		return null;
	}

	private int getCmdNum(String cmd) {
		String[] cmdBits = cmd.split(" ");
		
		try {
			int id = Integer.parseInt(cmdBits[2]);
			return id;
		} 
		catch (NumberFormatException e) {
			return 0;
		}
		
	}

	private void makeTestData() {
		System.out.println("테스트용 게시글 데이터 3개 생성");
		for(int i = 1; i <= 5; i++) {
			articles.add(new Article(lastArticleId++, Util.getDateStr(), "제목"+i, "내용"+i, i*10));
		}
		
	}
}
