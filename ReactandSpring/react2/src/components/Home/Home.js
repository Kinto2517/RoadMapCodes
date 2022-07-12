import React from "react";
import { useEffect, useState } from "react";
import Post from "../Post/Post";
import Container from "@mui/material/Container";


const Home = () => {
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [postList, setPostList] = useState([]);

  useEffect(() => {
    fetch("/posts", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((res) => res.json())
      .then((result) => {
        setIsLoaded(true);
        setPostList(result);
      });
  }, []);

  if (error) {
    return <div>Error: {error.message}</div>;
  } else if (!isLoaded) {
    return <div>Loading...</div>;
  } else {
    return (
      <div>
        <h2>Posts</h2>
        {postList.map((post) => (
          <Container fixed>
              <Post userId={post.userId} userName={post.userName} title={post.title} text={post.text}></Post>
          </Container>
        ))}
      </div>
    );
  }
};

export default Home;
