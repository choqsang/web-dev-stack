import React from "react";
import { Link } from "react-router-dom";

const UserList = ({ users }) => {
  return (
    <div>
      {users.map((u) => {
        return (
          <div class="card mb-2">
            <div class="card-body" value={u.id}>
              {/* <Link to={"/users/" + u.id}>{u.name}</Link> */}
              <Link to={`/users/${u.id}`}>{u.name}</Link>
              {/* Link to 에서 직접적으로 변수 접근이 불가하기 때문에
              Template Literal :  `${변수}` 를 사용하여 불러온다 */}
            </div>
          </div>
        );
      })}
    </div>
  );
};

export default UserList;
