import React, { useState, useEffect } from "react";
import axios from "axios";
import UserList from "../components/UserList";
import Spinner from "../components/Spinner";
import { useParams } from "react-router-dom";

const User = () => {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);
  const { id } = useParams();
  // useParams();는 URL의 경로에 포함된 값을 가져옴
  // useLocation();는 URL에 노출되지 않는 추가 데이터(state)를 가져옴

  useEffect(() => {
    axios
      .get("https://jsonplaceholder.typicode.com/users/" + id) // 파라미터를 묶어서 보냄
      .then((response) => {
        // alert(response.data.name);
        setUser(response.data);
        setLoading(false);
      });
  });

  const userDetail = loading ? (
    <Spinner />
  ) : (
    <div>
      <div>{user.name}</div>
      <div>{user.email}</div>
      <div>{user.phone}</div>
    </div>
  );

  return (
    <div>
      <h1>유저 정보</h1>
      {userDetail}
    </div>
  );
};

export default User;
