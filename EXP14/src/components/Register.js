import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Register() {
  const [user, setUser] = useState({ name: "", email: "", password: "" });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/register", user);
    alert("Registered Successfully");
    navigate("/");
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Register</h2>
      <input name="name" placeholder="Name" onChange={handleChange} />
      <input name="email" placeholder="Email" onChange={handleChange} />
      <input name="password" type="password" onChange={handleChange} />
      <button type="submit">Register</button>
    </form>
  );
}

export default Register;