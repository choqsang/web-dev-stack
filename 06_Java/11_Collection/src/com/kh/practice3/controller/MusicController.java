package com.kh.practice3.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.kh.practice3.compare.SongAscending;
import com.kh.practice3.model.Music;

public class MusicController {

	
	private Scanner sc = new Scanner(System.in);
	public ArrayList<Music> list = new ArrayList<>();
	
	//1. 특정 곡 추가
		public void addList() {
			/*
			 * ****** 특정 곡 추가 ******
			 * 곡명 : 
			 * 가수명 : 
			 * 
			 * 곡 추가 성공하면 "추가 성공"
			 *       실패하면 "추가 실패" -> 기존 똑같은 곡과 가수가 있을 시
			 * */
			System.out.println("****** 특정 곡 추가 ******");
			System.out.print("곡명 : ");
			String song = sc.nextLine();
			System.out.print("가수명 : ");
			String artist = sc.nextLine();
			
			boolean check = false;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getSong().equals(song) && list.get(i).getArtist().equals(artist)) {
					check = true;
					break;
				}
			}
			
			if (check) {
				System.out.println("추가 실패");
			} else {
				System.out.println("추가 성공");
				list.add(new Music(song, artist));
				}
			}
		
//		public boolean addList1(String artist, String song) {
//			for(Music m : list) {
//				if(m.getSong().equals(song) && m.getArtist().equals(artist)) {
//					return false;
//				}
//			} if(artist.trim().equals("") || song.trim().equals("")) { // 공백값 경우의 수 제거
//				return false;
//			}
//			return list.add(new Music(artist, song));
//		}		=> addList() 메서드 풀이

		
		
		//2. 전체 곡 목록 출력
		public void printAll() { // return list; 그대로 넘겨도 된다.
			/*
			 * ****** 전체 곡 목록 출력 ******
			 * */
			
			System.out.println("****** 전체 곡 목록 출력 ******");
				if (list.isEmpty()) {
					System.out.println("목록이 비어있습니다.\n\n");
				} else {
					for(Music m : list) {
					System.out.println(m);
				}
			}
		}
		
		//3. 특정 곡 검색
		public void searchMusic() {
			/*
			 * ****** 특정 곡 검색 ******
			 * 검색할 가수명/곡명 :  
			 * 
			 * 검색할 곡이 있다면 "(가수 - 곡)을 검색했습니다."
			 *          없다면 "검색할 곡을 찾지 못했습니다."
			 * */
			System.out.println("****** 특정 곡 검색 ******");
			System.out.print("검색할 가수명/곡명 : ");
			String search = sc.nextLine();
			
			boolean check = false;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getSong().equals(search) || list.get(i).getArtist().equals(search)) {
					System.out.println(
					"가수명 : " + list.get(i).getArtist() + " - 곡명 : " + list.get(i).getSong() + "을 검색했습니다.");
					// or 이라서 A에서 걸리면 B가 패스되는 문제!
					check = true;
					break;
				}
				if (!check) {
					System.out.println("검색할 곡을 찾지 못했습니다.");
				}
			}
		}
		
//		ArrayList<Music> result = searchMusic1(search);
//		public Music searchMusic1(String search) { // 리턴 활용 , 클래스로 유형값 변경
//			for(Music m : list) {
//				if(search.equalsIgnoreCase(m.getSong())) { // 대·소문자 무시하고 값 일치 시
//						search.contains(m.getSong())) { // 일부 포함할 경우, contains 비교 시 대소문자 구분 무시가 되지 않기 때문에 아래과 같이
//						search.toLowerCase().contains(m.getSong().toLowerCase())) 일괄 소문자로 변경 후 값 비교는 가능하다!
//					result.add(m);
//				}
//			}
//			return result;
//		
//			if(!result.isEmpty()) {
//				System.out.println("(" + result.getArtist() + " - " + result.getSong() + ")을 검색했습니다.");
//			} else {
//				System.out.println("검색할 곡을 찾지 못했습니다.");
//			}
//		}		=> searchMusic() 메서드 풀이
		
		
		// 곡 검색 시 중복된 경우
		public ArrayList<Music> checkMusic(String song) {
			ArrayList<Music> result = new ArrayList<>();
			for(Music m : list) {
				if(m.getSong().equals(song)) {
					result.add(m);
				}
			} return result;
		}
		
		//4. 특정 곡 수정
		public void updateMusic() {
			/*
			 * ****** 특정 곡 수정 ******
			 * 검색할 곡명 : 
			 * 수정할 곡명 : 
			 * 수정할 가수명 : 
			 * 
			 * 수정에 성공한다면 "(바꾸기 전 가수 - 바꾸기 전 곡)의 값이 변경되었습니다."
			 *       실패한다면 "곡을 수정하지 못했습니다."
			 * */ 
			
			System.out.println("****** 특정 곡 수정 ******");
			System.out.print("검색할 곡명 : ");
			String sSong = sc.nextLine();
			System.out.print("수정할 곡명 : ");
			String mSong = sc.nextLine();
			System.out.print("수정할 가수명 : ");
			String mArtist = sc.nextLine();
			
			
			boolean check = false;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getSong().equals(sSong)) {
					System.out.println(
					"가수명 : " + list.get(i).getArtist() + " - 곡명 : " + list.get(i).getSong() + "의 값이 변경되었습니다.");
					list.get(i).setSong(mSong);
					list.get(i).setArtist(mArtist);
					check = true;
					break;
				}
				if (!check) {
					System.out.println("곡을 수정하지 못했습니다.");
				}

			}
		}

		// 입력 받은 곡 명이 리스트 내 여러 개일 경우
//		public String checkMusic(String song) {
//		ArrayList<Music> result = checkMusic(search);
//		String searchArtist = null;
//		Music update = updateMusic(search, searchArtist, new Music(mArtist, mSong));
//		
//		if(result.size()>1) {
//			for(Music m : list) {
//				System.out.println(m);
//			} 
//			System.out.print("가수명 입력 : ");
//			searchArtist = sc.nextLine();
//			}
//		}
//		public Music updateMusic1(String search, String searchArtist, String mSong, String mArtist) {
//			for(Music m : list) {
//				boolean checkSong = m.getSong().equals(search);
//				boolean checkArtist = m.getArtist().equals(searchArtist);
//		
//			// 기존 리스트에 수정할 값이 존재하는 경우, 수정하지 못하도록!
//				if(searchArtist == null && checkSong || checkSong && checkArtist) {
//					if(m.getSong().equals(update.getSong())
//							&& m.getArtist().equals(update.getArtist())) {
//						return null;
//					}
//					return list.set(list.indexOf(m), update);
//					} 
//				}
//			}
//			return null;
//		
//			if(update!=null) {
//				System.out.println(update.getArtist() + " - " + update.getSong() + "을 수정했습니다.");
//			} else {
//				System.out.println("기존에 이미 있는 곡입니다.");
//			}
//		}		=> updateMusic() 메서드 풀이
		
		//5. 특정 곡 삭제
		public void removeMusic() {
			/*
			 * ****** 특정 곡 삭제 ******
			 * 삭제할 곡명 : 
			 * 
			 * 삭제에 성공한다면 "(삭제한 가수 - 삭제한 곡)을 삭제했습니다."
			 *      실패한다면 "삭제할 곡이 없습니다."
			 * */	
			
			//remove
			System.out.println("****** 특정 곡 삭제 ******");
			System.out.print("삭제할 곡명 : ");
			String dSong = sc.nextLine();
			
			boolean check = false;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getSong().equals(dSong)) {
					System.out.println(
					"가수명 : " + list.get(i).getArtist() + " - 곡명 : " + list.get(i).getSong() + "을 삭제했습니다.");
					list.remove(i);
					check = true;
					break;
				}
				if (!check) {
					System.out.println("삭제할 곡이 없습니다.");
				}

			}
		}
		
//		public String checkMusic(String song) {
//		ArrayList<Music> result = checkMusic(search);
//		String searchArtist = null;
//		Music update = updateMusic(search, searchArtist, new Music(mArtist, mSong));
//		
//		if(result.size()>1) {
//			for(Music m : list) {
//				System.out.println(m);
//			} 
//			System.out.print("가수명 입력 : ");
//			searchArtist = sc.nextLine();
//			} 
//		return searchArtist; 
//		}
//		
//		String artist = checkMusic(song);
//		public Music removeMusic1(String dSong, String artist) {
//			for(Music m : list) {
//				if(artist == null && m.getSong().equals(dSong) || m.getSong().equals(dSong) && m.getArtist().equals(artist)) {
//					return list.remove(m); // 객체로 받을 때 => 리턴타입은 boolean
//					return list.remove(list.indexOf(m)); // index로 받을 때 => 리턴타입은 Music
//				}
//			}
//			return null;
//		}		=> removeMusic() 메서드 풀이
	
		// * 기능 추가 : 가수명 내림차순 정렬
		public void descArtist() {
			System.out.println("***** 가수명 내림차순 정렬 *****");
			ArrayList<Music> clone = (ArrayList<Music>) list.clone(); // 기존 정렬이 변경되지 않도록 클론 생성 (해당 메서드 안에서만 재정렬)
			Collections.sort(clone); // 정렬에는 비교값이 필요하므로 클래스에 오버라이딩 필수!
			Collections.reverse(clone);
			System.out.println(clone);
		}
		
		// * 기능 추가 : 곡명 오름차순 정렬
		public void ascSong() {
			System.out.println("***** 곡명 오름차순 정렬 *****");
			ArrayList<Music> clone = (ArrayList<Music>) list.clone();
			Collections.sort(clone, new SongAscending());
			System.out.println(clone);
		}
		
/*
 * 메인(Application)과 컨트롤러 단을 분리할 때,
 * 컨트롤러에는 연산, 기능적인 부분을 기재한 후 리턴 타입에 맞춰 리턴값을 제시한다.
 * 이후 메인에서 컨트롤러에서 정의된 메서드를 불러오고,
 * 조건식 + 입력/출력(Scan/Print)에 대한 부분을 기재할 수 있도록 연습해보자!
 * */
		
}