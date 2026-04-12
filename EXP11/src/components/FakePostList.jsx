import React, { useEffect, useState } from "react";
import axios from "axios";

function FakePostList() {
  const [posts, setPosts] = useState([]);
  const [filter, setFilter] = useState("");

  const fetchData = () => {
    axios.get("https://dummyjson.com/posts")
      .then((res) => {
        setPosts(res.data.posts);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  useEffect(() => {
    fetchData();
  }, []);

  const filteredPosts = posts.filter((post) =>
    filter ? post.userId.toString() === filter : true
  );

  return (
    <div>
      <h2>Fake API Posts</h2>

      {/* Dropdown Filter */}
      <select onChange={(e) => setFilter(e.target.value)}>
        <option value="">All Users</option>
        <option value="1">User 1</option>
        <option value="2">User 2</option>
        <option value="3">User 3</option>
      </select>

      {/* Refresh Button */}
      <button onClick={fetchData}>Refresh</button>

      {filteredPosts.map((post) => (
        <div key={post.id}>
          <h4>{post.title}</h4>
          <p>{post.body}</p>
          <hr />
        </div>
      ))}
    </div>
  );
}

export default FakePostList;