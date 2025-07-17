//$(document).ready(function () {});
$(function () {
  // const h1 = document.querySelector("h1");
  // const pList = document.querySelectorAll("p");

  // h1.style.color = "blue";
  // for (p of pList) {
  // p.style.color = "white";
  // p.style.backgroundColor = "tomato";
  //}

  // 제이쿼리 방식
  $("h1").css("color", "blue");
  $("p").css({
    color: "white",
    "background-color": "tomato",
  });
  $("p").first().css("font-size", "4rem");
  $("p:last").css("color", "yellow");
  $("p:eq(2)").text("eq로 다시 글 작성합니다");
  $(".wrap").children().css({ color: "deeppink", border: "2px solid" });
  $(".wrap").find("h1").css({ color: "orange" });
  $("h1").siblings("p").css("background-color", "navy");

  // DOM 객체
  // 자바스크립트
  const p = document.createElement("p");
  p.innerText = "자바스크립트로 추가";
  document.querySelector("#content").appendChild(p);

  // 제이쿼리
  const p2 = $("<p>").html("제이쿼리로 추가");
  $("#content").append(p2);
  // append 해당 자식 요소 뒷 부분에 추가 (appendTo : 같은 기능이지만 문법 순서가 반대)
  $("#item").append("<span>append </span>");
  $("<span>appendTo</span>").appendTo("#item");
  // prepend 해당 자식 요소 앞 부분에 추가 (순서가 뒤지만 append 앞에 위치함)
  $("#item").prepend("<span>prepend </span>");
  // after 해당 형제 요소로 뒷 부분에 추가
  $("#item").after("<span>after</span>");
  // before 해당 형제 요소로 앞 부분에 추가
  $("#item").before("<span>before</span>");

  // 이벤트
  /*$("#textarea").on({
    // 키보드 눌려질 때
    keydown: (e) => {
      console.log(`keydown - e.key : ${e.key}, e.keyCode : ${e.keyCode}`);
    },
    // 키보드 입력될 때
    keypress: (e) => {
      console.log(`keypress - e.key : ${e.key}, e.keyCode : ${e.keyCode}`);
    },
    // 키보드 떼어질 때
    keyup: (e) => {
      console.log(`keyup - e.key : ${e.key}, e.keyCode : ${e.keyCode}`);
    },
  }); */

  $("#textarea").keyup((e) => {
    let target = $(e.target);
    let length = target.val().length;
    if (length > 50) {
      target.val(target.val().substr(0, 50));
    } else {
      $("#counter").text(length);
    }
  });

  $("#userId").keyup((e) => {
    let id = $(e.target).val(); // 제이쿼리 방식
    id = e.target.value; // 자바스크립트 방식
    const idTest = /^[a-z][0-9a-z]{3,11}$/;
    if (idTest.test(id)) {
      $("#idCheck").text("사용 가능한 아이디입니다.").css("color", "green");
    } else if (id === "") {
      $("#idCheck").text("");
    } else {
      $("#idCheck").text("사용 불가능한 아이디입니다.").css("color", "red");
    }
  });
});
