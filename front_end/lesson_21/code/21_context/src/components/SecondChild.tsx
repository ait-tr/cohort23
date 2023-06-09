import React, { useContext } from "react";
import { UserContext } from "../utils/utils";

const SecondChild = () => {
    const users = useContext(UserContext);
    console.log(users);
    
    return (
        <></>
    )
}

export default SecondChild;