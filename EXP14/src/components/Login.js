import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Login() {
  const [login, setLogin] = useState({ email: "", password: "" });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setLogin({ ...login, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const res = await axios.post("http://localhost:8080/login", login);

    if (res.data) {
      localStorage.setItem("user", JSON.stringify(res.data));
      navigate("/home");
    } else {
      alert("Invalid Credentials");
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Login</h2>
      <input name="email" placeholder="Email" onChange={handleChange} />
      <input name="password" type="password" onChange={handleChange} />
      <button type="submit">Login</button>
    </form>
  );
}

export default Login;