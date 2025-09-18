import React, { useState, useEffect } from "react";
import axios from "axios";
import UserList from "../components/UserList";
import Spinner from "../components/Spinner";

const Users = () => {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // 웹에 준비되어 있는 유저 정보를 가져온다
    axios
      .get("https://jsonplaceholder.typicode.com/users")
      // json 형태 정보가 response에 data로 담겨 있음
      .then((response) => {
        // alert(response.data[0].name); // 페이지 로드 시 0번 index에 담긴 name값 출력 test
        setUsers(response.data); // users 배열에 동기화
        setLoading(false); // 로드 종료 시 false로 spinner 비활성화
      });
  });

  return (
    <div>
      <h1>유저 목록 페이지</h1>
      {loading ? <Spinner /> : <UserList users={users} />}
    </div>
  );
};

export default Users;
