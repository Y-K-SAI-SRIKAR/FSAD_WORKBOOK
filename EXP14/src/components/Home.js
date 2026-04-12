import { useEffect } from "react";
import { useNavigate } from "react-router-dom";

function Home() {
  const navigate = useNavigate();

  useEffect(() => {
    const user = localStorage.getItem("user");
    if (!user) {
      navigate("/");
    }
  }, []);

  return <h2>Welcome to Home Page</h2>;
}

export default Home;