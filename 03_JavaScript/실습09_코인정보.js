// 방식 CRUD get, post,

/* https://api.upbit.com/v1/market/all
 {
    "market": "KRW-BTC",
    "korean_name": "비트코인",
    "english_name": "Bitcoin"
  },

  https://api.upbit.com/v1/ticker
  https://api.upbit.com/v1/ticker?markets=KRW-BTC,BTC-ETH
  ㄴ Request Parameters : api별로 필수적으로 요구하는 값(양식: ?뒷부분)에 따라 보내야 불러올 수가 있다.

  */

// async function dataFetch() {}
// const dataFetch = async function() {}

const market = document.querySelector("#market");
const dataFetch = async () => {
  const response = await fetch("https://api.upbit.com/v1/market/all");
  //   console.log(response);
  const data = await response.json();
  //   console.log(data);
  //   for (let i = 0; i < data.length; i++) {}
  //   data.forEach((item) => {
  // startsWith : 시작하는 단어 여부, includes : 단어 포함 여부
  // console.log(item);
  // console.log(item.market, item.market.includes("KRW"));
  // if (item.market.includes("KRW"))
  //   market.innerHTML += `<h4>${item.korean_name} (${item.market})</h4>`;
  //   });
  // ** forEach + 조건문 -> filter **
  const krwMarkets = data.filter((item) => item.market.includes("KRW"));
  //   let markets = "";
  //   krwMarkets.forEach((item) => {
  //     markets += item.market + ",";
  //   });
  //   console.log(markets.slice(0, -1));
  // const tickerResponse = await fetch(
  // `https://api.upbit.com/v1/ticker?markets=${markets.slice(0, -1)}` // markets 뒤에 원하는 변수 붙일 수 있다.

  // forEach + 내가 원하는 형태로 가공하고자 할 때 → map
  const markets = krwMarkets.map((item) => item.market).join(",");

  const tickerResponse = await fetch(
    `https://api.upbit.com/v1/ticker?markets=${markets}`
  );
  const tickerData = await tickerResponse.json();
  console.log(tickerData);

  krwMarkets.forEach((item) => {
    const ticker = tickerData.find((ticker) => ticker.market === item.market);
    // find : 조건에 해당하는 값을 찾아낸다.
    console.log(ticker);

    market.innerHTML += `<h4>${item.korean_name} (${item.market})</h4>
    <p>현재가 : ${ticker.trade_price.toLocaleString()}원</p>
    <p>24시간 거래량 : ${ticker.acc_trade_volume_24h.toFixed(2)}원</p>
    <p>전일 대비 : ${
      ticker.change === "RISE"
        ? "상승"
        : ticker.change === "FALL"
        ? "하락"
        : "보합"
      // 삼항 연산자 사용 시 편리하다.
    } (${(ticker.change_rate * 100).toFixed(2)}%)</p>
    `;
    // .toLocaleString() : 화폐 단위를 나타낼 때 자릿수 구분
    // .toFixed(2) : 소숫점 둘째 자리까지 나타낸다.
  });
};
dataFetch();

/* https://db-engines.com/en/ranking
Relational DBMS (관계형 데이터베이스) - 테이블 형태로 모두 연결되어있음
Oracle, MySQL 유료화 / 마리아DB, 몽고DB(관계형X:DOCU), PostgreSQL 대체
오라클로 교육을 진행하나, 실제로 과제나 프로젝트 등은 'MySQL'로 진행할 예정임. 

오라클 비밀번호 (공통) : qwer1234 */
