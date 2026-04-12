import { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

function Profile() {
  const [user, setUser] = useState({});
  const navigate = useNavigate();

  useEffect(() => {
    const storedUser = JSON.parse(localStorage.getItem("user"));

    if (!storedUser) {
      navigate("/");
      return;
    }

    axios
      .get(`http://localhost:8080/user/${storedUser.id}`)
      .then((res) => setUser(res.data));
  }, []);

  return (
    <div>
      <h2>Profile</h2>
      <p>Name: {user.name}</p>
      <p>Email: {user.email}</p>
    </div>
  );
}

export default Profile;