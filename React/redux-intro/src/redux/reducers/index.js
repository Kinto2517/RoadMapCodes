import { combineReducers } from "redux";
import counterReducer from "./counterReducer";

const reducers = combineReducers({
    // reducers
    counterReducer: counterReducer

});


export default reducers;

