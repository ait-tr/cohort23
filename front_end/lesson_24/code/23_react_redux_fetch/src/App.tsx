import React from 'react';
import './App.css';
import DataFetcher from './components/DataFetcher';
import { setComments, setPosts, setUsers } from './reducer/reducers';
import Posts from './components/Posts';
import Comments from './components/Comments';

function App() {
  return (
    <div className="App">
      <DataFetcher
        endpoint='https://jsonplaceholder.typicode.com/users'
        action={setUsers}
      />
      <DataFetcher
        endpoint='https://jsonplaceholder.typicode.com/posts'
        action={setPosts}
      />
      <DataFetcher
        endpoint='https://jsonplaceholder.typicode.com/comments'
        action={setComments}
      />
      <Posts />
      <Comments />
    </div>
  );
}

export default App;
