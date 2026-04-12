import { Link, useNavigate } from "react-router-dom";

function Navbar() {
  const navigate = useNavigate();

  const logout = () => {
    localStorage.removeItem("user");
    navigate("/");
  };

  return (
    <nav>
      <Link to="/home">Home</Link> | 
      <Link to="/profile">Profile</Link> | 
      <button onClick={logout}>Logout</button>
    </nav>
  );
}

export default Navbar;