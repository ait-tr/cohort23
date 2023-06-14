import { CounterAction } from "../actions/counterAction";

export interface CounterState {
    count: number;
}

const initialState: CounterState = {
    count: 0,
};

// reducer в качестве параметров принимает state и action
// а возвращает всегда(!) обновлённый state
const counterReducer = (
    state = initialState,
    action: CounterAction
): CounterState => {
    switch (action.type) {
        case "INCREMENT":
            return {
                ...state,
                count: state.count + 1,
            };
        case "DECREMENT":
            return {
                ...state,
                count: state.count - 1,
            };
        default:
            return state;
    }
};

export default counterReducer;