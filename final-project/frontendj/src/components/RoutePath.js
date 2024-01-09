import FrontPage from "../pages/FrontPage";
import {DetailedPage} from "../pages/DetailedPage";
import NotFound from "../pages/NotFound";
import { Router, Routes, Route} from 'react-router-dom';
export const  RoutePath =  () => {
    return (
        <Routes>
            <Route path="/frontpage" element={<FrontPage />} />
            <Route path="notfound" element={<NotFound />} />
        </Routes>
    )


}