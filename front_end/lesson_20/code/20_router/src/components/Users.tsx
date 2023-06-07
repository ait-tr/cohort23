import React from 'react';
import { Link } from 'react-router-dom';


const Users = () => {
    return (
        <>
            <h2>Пользователи</h2>

            <Link to="/"><button>Home</button></Link>
            <Link to="/about"><button>About</button></Link>
            
            
        </>
    );
};

export default Users;