import React, { useEffect, useState } from "react";
import api from "../api";


export default function ViewText({ fileId }) {
const [text, setText] = useState("");


useEffect(() => {
api.get(`/upload/${fileId}/text`).then((res) => {
setText(res.data.text || "No text extracted");
});
}, [fileId]);


return (
<div className="card">
<h3>Extracted Text</h3>
<textarea rows="10" value={text} readOnly />
</div>
);
}