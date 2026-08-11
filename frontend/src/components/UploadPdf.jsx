import { useState } from "react";
import api from "../api";


export default function UploadPdf({ onUploaded }) {
const [file, setFile] = useState(null);
const [loading, setLoading] = useState(false);


const upload = async () => {
if (!file) return alert("Select a PDF");


const formData = new FormData();
formData.append("file", file);


setLoading(true);
try {
const res = await api.post("/upload", formData);
onUploaded(res.data.fileId);
alert("Uploaded successfully");
} catch {
alert("Upload failed");
}
setLoading(false);
};


return (
<div className="card">
<h3>Upload PDF</h3>
<input type="file" accept="application/pdf" onChange={(e) => setFile(e.target.files[0])} />
<button onClick={upload} disabled={loading}>
{loading ? "Uploading..." : "Upload"}
</button>
</div>
);
}
