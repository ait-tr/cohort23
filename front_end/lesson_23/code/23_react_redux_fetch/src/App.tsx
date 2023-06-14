import React from 'react';
import './App.css';
import { useDispatch, useSelector } from 'react-redux';
import { RootState } from './store/store';
import { setPage } from './reducer/reducers';
import RenderUsers from './components/RenderUsers';

function App() {
  const dispatch = useDispatch();
  const users = useSelector((state: RootState) => state.users.users);
  const currentPage = useSelector((state: RootState) => state.users.currentPage);
  const totalPages = Math.ceil(users.length / 10);

  const handlePageChange = (page: number) => {
    dispatch(setPage(page));
  }

  

  return (
    <div className="App">
      <RenderUsers />
    </div>
  );
}

export default App;
