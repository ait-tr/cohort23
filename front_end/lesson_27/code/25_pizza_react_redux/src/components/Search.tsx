import React, { useRef, useState } from "react";
import { useDispatch } from "react-redux";
import { onClickCategory } from "../redux/slices/filterSlice";

const Search: React.FC = () => {

    const [localValue, setLocalValue] = useState<string>('');
    const dispatch = useDispatch();
    const [active, setActive] = useState<boolean>(false);
    const [isFocus, setIsFocus] = useState<boolean>(false);

    // Хук useRef - один из методов, который предоставляет React
    // для получения ссылки на JSX.Element
    const inputRef = useRef<HTMLInputElement>(null);

    const onChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setLocalValue(e.target.value);
        dispatch(onClickCategory(0));
    };

    const onClickClear = () => {
        setLocalValue('');
        // Один из классических примеров использования хука useRef.
        // С помощью ссылки на input элемент, мы установили фокус на нём
        inputRef.current?.focus();
    }

    return (
        <div className={`search ${isFocus ? 'search_focus' : ''}`}>
            <button onClick={() => setActive(!active)}></button>
            <input
                type="text"
                placeholder="Поиск товара..."
                // В атрибуте ref передаём то, что получили из хука useRef
                // В этом месте происходит связка между ссылкой (хук useRef) и элементом (в нашем случае - input)
                ref={inputRef}
                // Сработает, когда элемент будет в фокусе
                onFocus={() => setIsFocus(true)}
                // Сработает, когда элемент будет не в фокусе
                onBlur={() => setIsFocus(false)}
                onChange={onChange}
                value={localValue}
            />
            <button
                onClick={onClickClear}
            ></button>
        </div>
    );
};

export default Search;
