import React, { useState } from "react";
import MainPage from "./MainPage";
import LoginForm from "./LoginForm";

export default function Login() {
  const [email, setEmail] = useState("");
  const [isLogin, setLogin] = useState(false);

  return (
    <div>
      {isLogin ? (
        <MainPage email={email} />
      ) : (
        <LoginForm setLogin={setLogin} setEmail={setEmail} />
      )}
    </div>
  );
}
