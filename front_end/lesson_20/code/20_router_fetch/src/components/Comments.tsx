import React from "react";

interface IComment {
    id: number;
    body: string;
}

const Comments: React.FC<{ comments: IComment[] }> = ({ comments }) => {
    return (
        <>
            <h2>Comments</h2>
            {comments.map(comment => (
                <div key={comment.id} className='user'>
                    <p>Body: {comment.body}</p>
                </div>
            ))}
        </>
    );
};

export default Comments;
