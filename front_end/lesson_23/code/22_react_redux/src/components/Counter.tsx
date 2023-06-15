import React from "react";
import { useSelector } from "react-redux";
import { useDispatch } from "react-redux";
import { RootState, decrement, increment } from "../store/store";

const Counter = () => {

    // dispatch - это метод, внутри которого выполняются действия, связанные с изменением
    // глобального состояния. Сходий принцип с хуком useState, где state тоже можно изменять
    // только с помощью специального метода
    const dispatch = useDispatch();

    // с помощью useSelector получаем глобальное состояние 
    const counter = useSelector((state: RootState) => state.counter.value);

    const handleIncrement = () => {
        // dispatch -> слушатель изменениий RootState
        dispatch(increment());
    }

    const handleDecrement = () => {
        dispatch(decrement());
    }

    return (
        <div>
            <h2>Counter: {counter}</h2>
            <button onClick={handleIncrement}>Increment</button>
            <button onClick={handleDecrement}>Decrement</button>
        </div>
    );
};

export default Counter;