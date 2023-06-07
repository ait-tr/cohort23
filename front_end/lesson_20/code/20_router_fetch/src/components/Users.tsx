import React from 'react';

interface IUser {
    id: number;
    name: string;
    email: string;
}

const Users: React.FC<{ users: IUser[] }> = ({ users }) => {
    
    return (
        <>
            <h2>Users</h2>
            {users.map(user => (
                <div key={user.id} className='user'>
                    <p>Name: {user.name}</p>
                    <p>Email: {user.email}</p>
                </div>
            ))}
        </>
    );
};

export default Users;