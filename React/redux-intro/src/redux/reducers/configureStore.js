import { configureStore } from '@reduxjs/toolkit';

import reducers from './index';


 export default configureStore(reducers);