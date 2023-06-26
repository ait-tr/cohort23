import React from "react";
import { useSelector } from "react-redux";
import { useDispatch } from "react-redux";
import { selectFilter, setCurrentPage } from "../redux/slices/filterSlice";

const Pagination: React.FC = () => {
    const dispatch = useDispatch();
    const { currentPage } = useSelector(selectFilter);
    
    return (
        <div>
            <ul>
                <li>
                    <button
                        disabled={currentPage === 1}
                        onClick={() => dispatch(setCurrentPage(currentPage - 1))}>
                        {/*  */}
                        &lt;
                    </button>    
                </li>
                <li>
                    <button onClick={() => dispatch(setCurrentPage(1))}>
                        1
                    </button>    
                </li>
                <li>
                    <button onClick={() => dispatch(setCurrentPage(2))}>
                        2
                    </button>    
                </li>
                <li>
                    <button 
                        disabled={currentPage === 2}
                        onClick={() => dispatch(setCurrentPage(currentPage + 1))}>
                        &gt;
                    </button>    
                </li>
            </ul>
        </div>
    );
};

export default Pagination;
